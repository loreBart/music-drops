import 'package:flutter/material.dart';
import 'package:music_drops_flutter/model/auth/auth.dart';
import 'package:music_drops_flutter/ui/widgets/auth_provider_widget.dart';

class TopBarWidget extends StatelessWidget {

  @protected
  Widget build(BuildContext context) {
    Auth auth = AuthProviderWidget.of(context).auth;
    return AppBar(
      title: const Text('Music Drops'),
      actions: <Widget>[
      // action button
        IconButton(
          icon: Icon(Icons.account_circle),
          onPressed: () {
            print('account clicked!');
            auth.logout();    
          },
        ),
      ],
    );
  }

}
