
import 'package:flutter/material.dart';

class ResponsiveWidget extends StatelessWidget {

  @protected
  final Widget Function(BuildContext context, MediaQueryData mediaQueryData) builder;

  const ResponsiveWidget({ Key key, this.builder }) : super(key: key);

  @override
  Widget build(BuildContext context) => builder(context, MediaQuery.of(context));

}
