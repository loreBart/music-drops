class User {
  static const String COLUMN_UID          = 'uid';
  static const String COLUMN_PASSWORD     = 'password';
  static const String COLUMN_MAIL         = 'mail';
  static const String COLUMN_DISPLAY_NAME = 'displayName';
  static const String COLUMN_PHOTO_URL    = 'photoUrl';

  // --------------------
  String _uid;
  String _password;
  String _mail;
  String _displayName;
  String _photoUrl;
  // --------------------


  String get uid => _uid;
  String get password => _password;
  String get mail => _mail;
  String get displayName => _displayName;
  String get photoUrl => _photoUrl;

  User(this._uid, this._password, this._mail, this._displayName, this._photoUrl);


  User.fromJson(Map<String, dynamic> json)
    : this(json[COLUMN_UID],
           json[COLUMN_PASSWORD],
           json[COLUMN_MAIL],
           json[COLUMN_DISPLAY_NAME],
           json[COLUMN_PHOTO_URL]);

  Map<String, dynamic> toJson() =>
    {
      COLUMN_UID: _uid,
      COLUMN_PASSWORD: _password,
      COLUMN_MAIL: _mail,
      COLUMN_DISPLAY_NAME: _displayName,
      COLUMN_PHOTO_URL: _photoUrl,
    };

  @override
  String toString() => toJson().toString();
  

}