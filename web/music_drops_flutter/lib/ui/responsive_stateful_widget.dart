
import 'package:flutter/material.dart';
import 'package:music_drops_flutter/ui/responsive_widget.dart';

abstract class ResponsiveStatefullWidget extends StatefulWidget {
  @override
  ResponsiveState createState();
}

abstract class ResponsiveState extends State<ResponsiveStatefullWidget> {

  @override
  Widget build(BuildContext context) {
    return ResponsiveWidget(builder: (context, mediaQueryData) {
      return buildResponsiveWidget(context, mediaQueryData);
    });
  }

  @protected
  Widget buildResponsiveWidget(BuildContext context, MediaQueryData mediaQueryData);

}
