import 'package:flutter/material.dart';
import 'package:music_drops_flutter/model/auth/auth.dart';
import 'package:music_drops_flutter/ui/widgets/auth_provider_widget.dart';
import 'package:music_drops_flutter/ui/widgets/loading_button.dart';

/*
void main() async {
  runApp(MultiProvider(
      providers: [
      ],
      child: MaterialApp(
        title: 'Secrets',//
        theme: ThemeData(
          brightness: Brightness.dark,
          primaryColor: Colors.orangeAccent,
          accentColor: Colors.deepPurpleAccent,
          primarySwatch: Colors.orange,
          fontFamily: 'Montserrat',
        ),
        home: _enterPage,
        //routes: <String, WidgetBuilder>{
        //  '/secret_login'  : (BuildContext context) => SecretLoginPage(),
        //  '/secret_home'   : (BuildContext context) => SecretHomePage(),
        //  '/secret_add'    : (BuildContext context) => SecretAddTextDialog()
        },
      )
    )
  );
}
*/
import 'package:firebase/firebase.dart' as firebase;
import 'package:music_drops_flutter/ui/widgets/login_widget.dart';

void main() {
  print('Music Drops: before app init');
  print('Music Drops: ${firebase.apps}');
  //  
  //
  var app = null;  
  if (firebase.apps.isEmpty) {
    print('Music Drops: Firebase has no app do init ...');
    app = firebase.initializeApp(
      apiKey: "AIzaSyBw0bxqIi8UWPzlsn5C4I7HMsU6wVqmPno",
      appId: "1:111524920273:web:9a510a85c25432c8a7fef0",
      authDomain: "music-drops.firebaseapp.com",
      databaseURL: "https://music-drops.firebaseio.com",
      projectId: "music-drops",
      storageBucket: "music-drops.appspot.com",
      messagingSenderId: "111524920273",
      measurementId: "G-9ET1M4ECSX");
  } else {
    print('Music Drops: Firebase app ALREADY INITIALIZED ...');
    app = firebase.apps[0];
  }
  print('Music Drops: App init done ...');
  print('Music Drops: $app');
  runApp(MyApp());

}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return AuthProviderWidget(
      auth: Auth(),
      child: MaterialApp(
        title: 'Flutter Demo',
        theme: ThemeData(
          brightness: Brightness.dark,
          primaryColor: Colors.orangeAccent,
          accentColor: Colors.deepPurple,
          primarySwatch: Colors.orange,
          fontFamily: 'Roboto'
        ),
        home: App() 
      )
    );
  }
}

class HomePage extends StatelessWidget {

  @override
  Widget build(BuildContext context) {  
    return Text('Logged In');
  }

}

class App extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final Auth auth = AuthProviderWidget.of(context).auth;
    return StreamBuilder<String>(
      stream: auth.onAuthChanged,
      builder: (context, AsyncSnapshot<String> snapshot) {
        print('App::build snapshot connection state ${snapshot.connectionState}');
        if (snapshot.connectionState == ConnectionState.active) {
          print('App::build snapshot active');
          final bool logged = snapshot.hasData;
          print('App::build snapshot logged -> $logged');
          return logged ? HomePage() : LoginWidget();
        }
      }
    );
  }
}

/*
void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        // This is the theme of your application.
        //
        // Try running your application with "flutter run". You'll see the
        // application has a blue toolbar. Then, without quitting the app, try
        // changing the primarySwatch below to Colors.green and then invoke
        // "hot reload" (press "r" in the console where you ran "flutter run",
        // or simply save your changes to "hot reload" in a Flutter IDE).
        // Notice that the counter didn't reset back to zero; the application
        // is not restarted.
        primarySwatch: Colors.blue,
        // This makes the visual density adapt to the platform that you run
        // the app on. For desktop platforms, the controls will be smaller and
        // closer together (more dense) than on mobile platforms.
        visualDensity: VisualDensity.adaptivePlatformDensity,
      ),
      home: MyHomePage(title: 'Flutter Demo Home Page'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  MyHomePage({Key key, this.title}) : super(key: key);

  // This widget is the home page of your application. It is stateful, meaning
  // that it has a State object (defined below) that contains fields that affect
  // how it looks.

  // This class is the configuration for the state. It holds the values (in this
  // case the title) provided by the parent (in this case the App widget) and
  // used by the build method of the State. Fields in a Widget subclass are
  // always marked "final".

  final String title;

  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  int _counter = 0;

  void _incrementCounter() {
    setState(() {
      // This call to setState tells the Flutter framework that something has
      // changed in this State, which causes it to rerun the build method below
      // so that the display can reflect the updated values. If we changed
      // _counter without calling setState(), then the build method would not be
      // called again, and so nothing would appear to happen.
      _counter++;
    });
  }

  @override
  Widget build(BuildContext context) {
    // This method is rerun every time setState is called, for instance as done
    // by the _incrementCounter method above.
    //
    // The Flutter framework has been optimized to make rerunning build methods
    // fast, so that you can just rebuild anything that needs updating rather
    // than having to individually change instances of widgets.
    return Scaffold(
      appBar: AppBar(
        // Here we take the value from the MyHomePage object that was created by
        // the App.build method, and use it to set our appbar title.
        title: Text(widget.title),
      ),
      body: Center(
        // Center is a layout widget. It takes a single child and positions it
        // in the middle of the parent.
        child: Column(
          // Column is also a layout widget. It takes a list of children and
          // arranges them vertically. By default, it sizes itself to fit its
          // children horizontally, and tries to be as tall as its parent.
          //
          // Invoke "debug painting" (press "p" in the console, choose the
          // "Toggle Debug Paint" action from the Flutter Inspector in Android
          // Studio, or the "Toggle Debug Paint" command in Visual Studio Code)
          // to see the wireframe for each widget.
          //
          // Column has various properties to control how it sizes itself and
          // how it positions its children. Here we use mainAxisAlignment to
          // center the children vertically; the main axis here is the vertical
          // axis because Columns are vertical (the cross axis would be
          // horizontal).
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Text(
              'You have pushed the button this many times:',
            ),
            Text(
              '$_counter',
              style: Theme.of(context).textTheme.headline4,
            ),
          ],
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: _incrementCounter,
        tooltip: 'Increment',
        child: Icon(Icons.add),
      ), // This trailing comma makes auto-formatting nicer for build methods.
    );
  }
}
*/