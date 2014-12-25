# IntentLogger

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

Then...

```
12-25 17:39:33.550    1195-1195/com.drivemode.intentlog.app V/test﹕ Intent[172e5d96] content:
12-25 17:39:33.551    1195-1195/com.drivemode.intentlog.app V/test﹕ Action   : android.intent.action.MAIN
12-25 17:39:33.551    1195-1195/com.drivemode.intentlog.app V/test﹕ Category : {android.intent.category.LAUNCHER}
12-25 17:39:33.551    1195-1195/com.drivemode.intentlog.app V/test﹕ Data     : null
12-25 17:39:33.551    1195-1195/com.drivemode.intentlog.app V/test﹕ Component: com.drivemode.intentlog.app/com.drivemode.intentlog.app.MainActivity
12-25 17:39:33.551    1195-1195/com.drivemode.intentlog.app V/test﹕ Flags    : 10000001100000000000000000000
12-25 17:39:33.551    1195-1195/com.drivemode.intentlog.app V/test﹕ Flag     : FLAG_RECEIVER_FOREGROUND
12-25 17:39:33.552    1195-1195/com.drivemode.intentlog.app V/test﹕ Flag     : FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY
12-25 17:39:33.552    1195-1195/com.drivemode.intentlog.app V/test﹕ Flag     : FLAG_ACTIVITY_RESET_TASK_IF_NEEDED
12-25 17:39:33.552    1195-1195/com.drivemode.intentlog.app V/test﹕ HasExtras: true
12-25 17:39:33.552    1195-1195/com.drivemode.intentlog.app V/test﹕ Extra[profile] :0
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
