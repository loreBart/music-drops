


import 'package:music_drops_flutter/model/user.dart';

abstract class AuthBase {
  Stream<String> get onAuthChanged;

  Future<User> login(String email, String password);
  Future<void> logout();

}