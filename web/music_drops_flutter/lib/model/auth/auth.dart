

import 'dart:async';

import 'package:firebase_auth/firebase_auth.dart';
import 'package:music_drops_flutter/model/auth/auth_base.dart';
import 'package:music_drops_flutter/model/user.dart';

class Auth implements AuthBase {

  final FirebaseAuth _auth = FirebaseAuth.instance;

  @override
  Stream<String> get onAuthChanged => _auth.onAuthStateChanged.map(
    (FirebaseUser user) => user?.uid
  );

  @override
  Future<User> login(String email, String password) async {
    Future<AuthResult> futureAuthResult = _auth.signInWithEmailAndPassword(email: email, password: password);
    AuthResult authResult = await futureAuthResult;
    FirebaseUser firebaseUser = authResult.user;
    User user = User(firebaseUser.uid, password, firebaseUser.email, firebaseUser.displayName, firebaseUser.photoUrl)
    var completer = Completer<User>();
    completer.complete(user);
    return completer.future;
  }

  @override
  Future<void> logout() => _auth.signOut();


}