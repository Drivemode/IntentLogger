# IntentLogger

[![Gitter](http://img.shields.io/badge/Gitter-Join%20Chat-brightgreen.svg?style=flat)](https://gitter.im/Drivemode/IntentLogger?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-IntentLogger-brightgreen.svg?style=flat)](http://android-arsenal.com/details/1/1270)
[![License](http://img.shields.io/badge/License-Apache%202-brightgreen.svg?style=flat)](https://github.com/Drivemode/IntentLogger/blob/master/LICENSE.md)
[![Circle CI](https://circleci.com/gh/Drivemode/IntentLogger/tree/master.svg?style=shield)](https://circleci.com/gh/Drivemode/IntentLogger/tree/master)

Dump intent content into logcat

## Usage

Call `IntentLogger.dump(String, Intent)`.

```
public class MainActivity extends Activity {
    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentLogger.dump("test", getIntent());
    }
}
```

Then in LogCat

```
app V/test﹕ Intent[172e5d96] content:
app V/test﹕ Action   : android.intent.action.MAIN
app V/test﹕ Category : {android.intent.category.LAUNCHER}
app V/test﹕ Data     : null
app V/test﹕ Component: com.drivemode.intentlog.app/com.drivemode.intentlog.app.MainActivity
app V/test﹕ Flags    : 10000001100000000000000000000
app V/test﹕ Flag     : FLAG_RECEIVER_FOREGROUND
app V/test﹕ Flag     : FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY
app V/test﹕ Flag     : FLAG_ACTIVITY_RESET_TASK_IF_NEEDED
app V/test﹕ HasExtras: true
app V/test﹕ Extra[profile] :0
```

cf. `Intent#toString()`

```
app V/test﹕ Intent { act=android.intent.action.MAIN cat=[android.intent.category.LAUNCHER] flg=0x10100000 cmp=com.drivemode.intentlog.app/.MainActivity bnds=[481,810][1312,1641] }
```

## Download

Gradle:

```
compile 'com.drivemode:IntentLogger:1.0.5@aar'
```

## License

Apache v2

```
Copyright (C) 2014 Drivemode, Inc. All rights reserved.

Licensed under the Apache License, Version 2.0 (the "License"); you may not use
this file except in compliance with the License. You may obtain a copy of the
License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed
under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
CONDITIONS OF ANY KIND, either express or implied. See the License for the
specific language governing permissions and limitations under the License.
```
