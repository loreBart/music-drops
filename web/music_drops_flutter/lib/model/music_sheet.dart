
import 'package:music_drops_flutter/model/author.dart';

class MusicSheet {
  // ================================================
  static const String AUTHOR_INVALID_ID  = null;
  static const String COLUMN_ID          = 'id';
  static const String COLUMN_NAME        = 'name';
  static const String COLUMN_DATA        = 'data';
  static const String COLUMN_AUTHORS     = 'authors';
  // ------------------------------------------------

  final String       _id;
  final String       _name;
  final String       _data;
  final List<Author> _authors;

  String       get id => _id;
  String       get name => _name;
  String       get data => _data;
  List<Author> get authors => _authors;

  MusicSheet(this._id, this._name, this._data, this._authors);

  MusicSheet.onlyNamed(String name) 
    : this(AUTHOR_INVALID_ID, name, null, null);
 
  MusicSheet.nameAndData(String name, String data) 
    : this(AUTHOR_INVALID_ID, name, data, null);

  MusicSheet.fromJson(Map<String, dynamic> json)
    : this(json[COLUMN_ID],
           json[COLUMN_NAME],
           json[COLUMN_DATA],
           json[COLUMN_AUTHORS]);

  Map<String, dynamic> toRow() => 
    {
      COLUMN_NAME: _name,
      COLUMN_DATA: _data,
      COLUMN_AUTHORS: _authors.map((e) => e.toRow()).toList(growable: false),
    };

  Map<String, dynamic> toJson() =>
    {
      COLUMN_ID: _id,
      COLUMN_NAME: _name,
      COLUMN_DATA: _data,
      COLUMN_AUTHORS: _authors.map((e) => e.toRow()).toList(growable: false),
    };


  addAuthor(Author author) => _authors.add(author);
  removeAuthor(Author author) => _authors.add(author);

  @override
  String toString() => toJson().toString();

}