
import 'package:music_drops_flutter/model/music_sheet.dart';

class Author {
  static const int    AUTHOR_INVALID_ID   = -1;
  static const String COLUMN_UID          = 'uid';
  static const String COLUMN_NAME         = 'name';
  static const String COLUMN_SURNAME      = 'surname';
  static const String COLUMN_DOF          = 'dateOfBirth';
  static const String COLUMN_MUSIC_SHEETS = 'musicSheets';

  // ===============================================
  final String     _uid;
  final String     _name;
  final String     _surname;
  final DateTime   _dateOfBirth;
  List<MusicSheet> _musicSheets = [];
  // -----------------------------------------------
  String           get uid => _uid;
  String           get name => _name;
  String           get surname => _surname;
  DateTime         get dateOfBirth => _dateOfBirth;
  List<MusicSheet> get musicSheets => _musicSheets;

  addMusicSheet(sheet) => _musicSheets.add(sheet);
  removeMusicSheet(sheet) => _musicSheets.remove(sheet);

  Author(this._name, this._surname, {String uid, DateTime dateOfBirth, List<MusicSheet> musicSheets})
    : _uid = uid, _dateOfBirth = dateOfBirth, _musicSheets = musicSheets;


  Author.byName(String name)
    : this(name, null);

  Author.byNameAndSurname(String name, String surname)
    : this(name, surname);

  Author.fromJson(Map<String, dynamic> json)
    : this(json[COLUMN_NAME],
           json[COLUMN_SURNAME],
           uid: json[COLUMN_UID],
           dateOfBirth: json[COLUMN_DOF],
           musicSheets: json[COLUMN_MUSIC_SHEETS]);

  Map<String, dynamic> toRow() => 
    {
      COLUMN_NAME:         _name,
      COLUMN_SURNAME:      _surname,
      COLUMN_DOF:          _dateOfBirth.toIso8601String(),
      COLUMN_MUSIC_SHEETS: _musicSheets.map((e) => e.toRow()).toList(growable: false)
    };

  Map<String, dynamic> toJson() =>
    {
      COLUMN_UID:          _uid,
      COLUMN_NAME:         _name,
      COLUMN_SURNAME:      _surname,
      COLUMN_DOF:          _dateOfBirth.toIso8601String(),
      COLUMN_MUSIC_SHEETS: _musicSheets.map((e) => e.toRow()).toList(growable: false)
    };

  @override
  String toString() => toJson().toString();


  @override
  int get hashCode =>
      _uid.hashCode     ^ _name.hashCode ^
      _surname.hashCode ^ _dateOfBirth.hashCode;

  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      other is Author &&
          runtimeType  == other.runtimeType &&
          _id          == other._id         &&
          _name        == other._name       &&
          _surname     == other._surname;

}