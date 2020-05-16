
import 'package:flutter/material.dart';

enum FormType {
  login,
  register
}


class LoginWidget extends StatefulWidget {
  @override
  State createState() => _LoginWidgetState();
}


class _LoginWidgetState extends State<LoginWidget> {
  FormType _formType = FormType.login;
  final    _keyForm = GlobalKey<FormState>();
  // ------------------------------------
  final    _keyEmail    = GlobalKey<FormFieldState>();
  final    _keyUsername = GlobalKey<FormFieldState>();
  final    _keyNickname = GlobalKey<FormFieldState>();
  final    _keyPassword = GlobalKey<FormFieldState>();
  // ------------------------------------
  bool     _passwordVisible = false;

  bool get isForLogin => _formType == FormType.login;

  @protected
  Widget build(BuildContext context) {
    return Container(
      child: Padding(
        padding: EdgeInsets.all(32),
        child: Center(
          child: ConstrainedBox(
            constraints: const BoxConstraints(
              minHeight: 560,
              maxHeight: 560,
              minWidth: 360,
              maxWidth: 400,
            ),
            child: Card(
              elevation: 12,
              
              child: Column(children: _buildLayoutFormHeader() +
                                      _buildLayoutFormContent())
            ),
          ),
        ) 
      )
    );
  }


  List<Widget> _buildLayoutFormHeader() {
    const avatar = Padding(
      padding: EdgeInsets.fromLTRB(0, 32, 0, 24),
      child: CircleAvatar(
        radius: 54,
        backgroundColor: Colors.deepPurpleAccent,
        child: CircleAvatar(
          radius: 53,
          backgroundImage: AssetImage('lib/assets/icons/ic_bach_music_sheet.jpg'),
        ),
      )
    );
    List<Widget> header = List();
    header.add(avatar);                  
    return header;
  }


  List<Widget> _buildLayoutFormContent() {
    List<Widget> content = List();
    content.addAll(isForLogin ? _buildLayoutLoginForm()
                              : _buildLayoutRegisterForm());                  
    content.addAll(_buildLayoutFormButtons());                  
    return content;
  }


  List<Widget> _buildLayoutLoginForm() {
    return [Form(
      key: _keyForm,
      child: Container(
        margin: const EdgeInsets.all(4),
        child: Column(
          children: <Widget>[
            _buildTextFormField(_keyEmail, 'Email'),
            _buildTextFormFieldPassword(_keyPassword, 'Password')
          ]
        ),
      )
    )];
  }


  List<Widget> _buildLayoutRegisterForm() {
    return [Form(
      key: _keyForm,
      child: Container(
        margin: const EdgeInsets.all(4),
        child: Column(
          children: <Widget>[
            _buildTextFormField(_keyUsername, 'Username'),
            _buildTextFormField(_keyNickname, 'Nickname'),
            _buildTextFormField(_keyEmail,    'Email'),
            _buildTextFormFieldPassword(_keyPassword, 'Password')
          ]
        ),
      )
    )];
  }

  Widget _buildTextFormField(Key key, String name) {
    return Padding(
      padding: EdgeInsets.fromLTRB(32, 8, 32, 4),
      child: TextFormField(
        key: key,
        style: TextStyle(fontSize: 14),
        keyboardType: TextInputType.emailAddress,
        decoration: InputDecoration(
          contentPadding: EdgeInsets.fromLTRB(16, 0, 16, 0),
          hintText: name,
          border: OutlineInputBorder(borderRadius: BorderRadius.circular(24)),
        ),
        validator: (value) {
          if (value.isEmpty) return name + ' is required';
          return null;
        },
      )
    );
  }

  Widget _buildTextFormFieldPassword(Key key, String name) {
    return Padding(
      padding: EdgeInsets.fromLTRB(32, 16, 32, 4),
      child: TextFormField(
        key: key,
        style: TextStyle(fontSize: 14),
        decoration: InputDecoration(
          contentPadding: EdgeInsets.fromLTRB(16, 0, 16, 0),
          hintText: name,
          border: OutlineInputBorder(borderRadius: BorderRadius.circular(32.0)),
          suffixIcon: GestureDetector(
            child: !_passwordVisible ? Icon(Icons.visibility_off) : Icon(Icons.visibility),
            onTap: () {
              setState(() { 
                _passwordVisible = !_passwordVisible;
              });
            }
          )
        ),
        obscureText: !_passwordVisible,
        validator: (value) {
          if (value.isEmpty) {
            return name + ' required';
          }
          return null;
        },
      ),
    );
  }

  List<Widget> _buildLayoutFormButtons() {
    return [
      Column(
        children: [
          Padding(
            padding: EdgeInsets.fromLTRB(0, 8, 0, 0),
            child: RaisedButton(
              padding: EdgeInsets.fromLTRB(24, 0, 24, 0),
              child: new Text(_formType == FormType.login ? 'Login' : 'Register'),
              onPressed: () {
                if (_keyForm.currentState.validate()) {
                  print('clicked state $_formType');
                }
              }
            )
          ),
          Padding(
            padding: EdgeInsets.fromLTRB(0, 8, 0, 8),
            child: SizedBox(
              height: 24,
              child: FlatButton(
                materialTapTargetSize: MaterialTapTargetSize.shrinkWrap,
                child: isForLogin ? Text('Register', style: TextStyle(fontSize: 10, color: Colors.white, decoration: TextDecoration.underline))
                                  : Row(
                  children: <Widget>[
                    Icon(Icons.arrow_back, color: Colors.white, size: 16),
                    Text('Back to Login', style: TextStyle(fontSize: 10, color: Colors.white, decoration: TextDecoration.underline)),
                  ]
                ),
                onPressed: () {
                  print('clicked state 1 -> $_formType');
                  setState(() {
                    _formType = _formType == FormType.login ? FormType.register : FormType.login;
                  });
                  print('clicked state 2 -> $_formType');
                },
              )
            )
          ),
        ])
      ];

  }


}