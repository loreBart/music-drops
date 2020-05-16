
import 'package:flutter/material.dart';
import 'dart:math';

class ShakeCurve extends Curve {
  @override
  double transform(double t) => sin(t * pi * 2);
}

class CircleWaveProgress extends StatefulWidget {
  final double width;

  CircleWaveProgress(this.width, {Key key}) : super(key: key);

  @override
  _CircleWaveProgressState createState() => _CircleWaveProgressState();
}

class _CircleWaveProgressState extends State<CircleWaveProgress>
    with SingleTickerProviderStateMixin {

  List<Color> waveColors = [
    Colors.red,
    Colors.orangeAccent,
    Colors.yellow[700],
    Colors.green[700],
    Colors.lightBlue,
    Colors.indigo,
    Colors.purple,
    Colors.deepPurple
    ];
  // ==================================
  int                 waveColorIx = 0;
  double              waveRadius = 0.0;

  Color               waveColor;
  Animation<double>   _animationRadius;
  AnimationController _controller;
  Animation           _animationCurve;
  bool                _isBusy;
  // ----------------------------------

  get isBusy => _isBusy;
  set isBusy(bool isBusy) {
    setState(() {
      _isBusy = isBusy;
    });
  }

  @override
  void initState() {
    super.initState();
    waveColor = waveColors[waveColorIx];
    _controller = AnimationController(duration: Duration(milliseconds: 800), vsync: this);
    _animationCurve = CurvedAnimation(parent: _controller, curve: Curves.easeOut);
    _controller.forward();
    _controller.addStatusListener((status) {
      if (status == AnimationStatus.completed) {
        _controller.reverse();
      } else if (status == AnimationStatus.dismissed) {
        int ix = ++waveColorIx % waveColors.length;
        waveColor = waveColors[ix];
        _controller.forward();
      }
    });
  }

  double hypot(double x, double y) => sqrt(x * x + y * y);

  @override
  Widget build(BuildContext context) {
    _animationRadius = Tween(begin: 0.0, end: widget.width/2).animate(_animationCurve)
      ..addListener(() {
        setState(() {
          waveRadius = _animationRadius.value;
        });
      });
    return Scaffold(
        backgroundColor: Colors.white,
        body: SizedBox(
          child: CustomPaint(
            size: Size(widget.width, widget.width),
            painter: CircleWavePainter(waveRadius, waveColor),
          ),
        )
      );
  }

  @override
  void dispose() {
    _controller.dispose();
    super.dispose();
  }

}


class CircleWavePainter extends CustomPainter {

  // ----------------------
  final Color  waveColor;
  final double waveRadius;
  Paint        wavePaint;
  // ----------------------
  Paint        debugPaint;

  CircleWavePainter(this.waveRadius, this.waveColor) {
    var gradient = RadialGradient(
      center: const Alignment(0, 0),
      radius: 0.2,
      colors: [this.waveColor,
               const Color(0xffffffff)
              ],
      stops: [0.4, 1.0],
    );
    wavePaint = Paint()
      ..color = waveColor
      ..style = PaintingStyle.fill
      ..strokeWidth = 1.0
      ..isAntiAlias = true;
    debugPaint = Paint()
      ..color = Colors.red[700].withAlpha(120)
      ..style = PaintingStyle.stroke
      ..strokeWidth = 1.0
      ..isAntiAlias = true;
  }

  @override
  void paint(Canvas canvas, Size size) {
    double centerX = size.width  / 2.0;
    double centerY = size.height / 2.0;
    double maxRadius = waveRadius;
    Rect bound = Rect.fromLTRB(0, 0, size.width, size.height);
    canvas.drawRect(Rect.fromLTRB(0, 0, size.width, size.height), debugPaint);
    /*
    var gradient = RadialGradient(
      center: const Alignment(0.7, -0.6),
      radius: 0.2,
      colors: [const Color(0xFFFFFF00), const Color(0xFF0099FF)],
      stops: [0.4, 1.0],
    );
    wavePaint..shader = gradient.createShader(bound);
    */
    canvas.drawCircle(Offset(centerX, centerY), maxRadius, wavePaint);
  }

  @override
  bool shouldRepaint(CircleWavePainter oldDelegate) => true;//oldDelegate.waveRadius != waveRadius && oldDelegate.waveColor != waveColor;

  double hypot(double x, double y) => sqrt(x * x + y * y);


}