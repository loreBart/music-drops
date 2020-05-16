

import 'package:flutter/material.dart';
import 'package:music_drops_flutter/ui/responsive_stateless_widget.dart';


class HeaderWidget extends ResponsiveStatelessWidget {

  @protected
  Widget buildResponsiveWidget(BuildContext context, MediaQueryData mediaQueryData) {
    return AppBar(
      leading: IconButton(
        icon: Icon(Icons.menu, color: Colors.white),
        onPressed: () {
          print('onClicked menu');
        },
      ),
      title: const Text('Music Drops'),
      actions: <Widget>[
      // action button
        IconButton(
          icon: Icon(Icons.account_circle),
          onPressed: () {
            print('account clicked!');
          },
        ),
            // action button
        IconButton(
          icon: Icon(Icons.music_note),
          onPressed: () {
            print('music note clicked!');
          },
        ),
      ],
    );
  }

}

