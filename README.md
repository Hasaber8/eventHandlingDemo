# Android Event Handling Demo Application

This simple Android application demonstrates two different methods of handling user interaction events in Android development.

## Event Handling Methods Demonstrated

### 1. Anonymous Inner Class Listener

**Location in code:** `MainActivity.java` (lines 16-22)

This method attaches a click listener to a view by creating an anonymous class that implements the `View.OnClickListener` interface.

```java
TextView myTextView = findViewById(R.id.helloTextView);
myTextView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Toast.makeText(getApplicationContext(),"Hello!",Toast.LENGTH_SHORT).show();
    }
});
```

Key characteristics:
- Programmatically sets the click listener
- Useful when the listener logic is specific to a particular instance
- No need to implement the interface in the Activity class
- Good for separating concerns when the view requires unique handling

### 2. Activity as Event Listener

**Location in code:**
- Interface implementation: `MainActivity.java` (line 9)
- Method implementation: `MainActivity.java` (lines 26-34)
- XML binding: `activity_main.xml` (line 24)

This method makes the Activity itself implement the `View.OnClickListener` interface, and then assigns it as the listener for views in the layout.

In the Activity class:
```java
public class MainActivity extends AppCompatActivity 
   implements View.OnClickListener {

    // ...
    
    @Override
    public void onClick(View view) {
        int theId = view.getId();
        if (theId == R.id.bingoButton) {
            Toast.makeText(getApplicationContext(),"Bingo!!!",Toast.LENGTH_SHORT).show();
        }
    }
}
```

In the layout XML:
```xml
<Button
    android:id="@+id/bingoButton"
    android:onClick="onClick"
    android:text="Bingo"
    ... />
```

Key characteristics:
- The Activity implements `View.OnClickListener`
- The click handler needs to distinguish between different views using their IDs
- The `onClick` attribute in XML binds the view to the Activity's method
- Useful when multiple views need similar handling or when centralizing event logic

## Usage

Run the application and:
1. Tap the "Hello World!" text to see a Toast message saying "Hello!"
2. Tap the "Bingo" button to see a Toast message saying "Bingo!!!"
