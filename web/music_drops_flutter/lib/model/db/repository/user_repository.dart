


import 'package:music_drops_flutter/model/user.dart';

abstract class UserRepository {
  Stream<List<User>> users();
  Future<bool> addUser(User user);
  Future<bool> removeUser(User user);
  Future<bool> updateUser(String id, User user);
}