import 'package:database/database.dart';
import 'package:music_drops_flutter/model/user.dart';
import 'package:database_adapter_postgre/database_adapter_postgre.dart';
import 'dart:async';

class UserStore {

  static const String DB_NAME    = 'users.db';
  static const String TABLE_NAME = 'users';
  // Note: we use only one database so we doesn't need to close it
  //       (it will be closed when the application is terminated)
  // In this example, we use PostgreSQL adapter
  Database db() {
    final database = Postgre(
      host:         'localhost',
      port:          8080,
      user:         'lor',
      password:     'lor',
      databaseName: TABLE_NAME,
    ).database();
    return database;
  }

  UserStore._privateConstructor();

  static final UserStore _store = UserStore._privateConstructor();

  static UserStore get store { return _store; }


  Future<void> addUser(User user) async {
    final dbInstance = await db();
    return dbInstance.sqlClient.table(TABLE_NAME).insert(user.toRow());
  }

  Future<List<User>> users() async {
    final sqlClient = db().sqlClient;
    var completer = Completer<List<User>>();
    final users  = await sqlClient.query(
      'SELECT * FROM '+ TABLE_NAME,
    ).toMaps();
    final usersList = List<User>.from(users);
    users.forEach((key) {
      var user = User.fromJson(key);
      usersList.add(user);
      print('user -> ${user.toString()}');
    });
    completer.complete(usersList);
    return completer.future;
  }

  Future<void> updateUser(User user) async {
    final sqlClient = db().sqlClient;
    return await sqlClient.execute(
      'insert into ' + TABLE_NAME + ' (' +
      User.COLUMN_MAIL + ',' + User.COLUMN_PASSWORD + ') values (?, ?) where ' +
      User.COLUMN_ID + ' = ?',
      [user.mail, user.password, user.id]);
  }

  Future<void> deleteUser(int id) async {
    final sqlClient = db().sqlClient;
    await sqlClient.execute('delete from ' + TABLE_NAME + ' where ' + User.COLUMN_ID + ' = ?', [id]);
  }

}

