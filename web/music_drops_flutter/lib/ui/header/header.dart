

import 'dart:ffi';

import 'package:flutter/material.dart';
import 'package:music_drops_flutter/ui/responsive_stateless_widget.dart';


class HeaderWidget extends StatelessWidget{

  @protected
  Widget build(BuildContext context) {
    return SizedBox(
      width: double.infinity,
      height: 154,
      child: Container(
        color: Colors.orange
      )
    );
  }

}

