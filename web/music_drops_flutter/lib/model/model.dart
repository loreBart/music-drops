
import 'package:flutter/material.dart';
import 'package:music_drops_flutter/model/user.dart';

class Model with ChangeNotifier {

  User _loggedUser;

  // 
  bool isLogged() => _loggedUser != null;

  void login(User user) => _logUser(user);

  void logout() => _logUser(null);

  _logUser(User loggedUser) {
    _loggedUser = loggedUser;
    notifyListeners();
  }

}