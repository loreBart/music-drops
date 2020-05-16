

import 'package:flutter/material.dart';
import 'package:music_drops_flutter/model/auth/auth_base.dart';

class AuthProviderWidget extends InheritedWidget {
  final AuthBase auth;

  AuthProviderWidget({this.auth, Key key, Widget child})
    : super(key: key, child: child);


  @override
  bool updateShouldNotify(InheritedWidget oldWidget) => true;


  static AuthProviderWidget of(BuildContext context) => 
    (context.dependOnInheritedWidgetOfExactType<AuthProviderWidget>());    
    
}