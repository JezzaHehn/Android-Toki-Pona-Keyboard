package tech.jezza.tokiponakeyboard;

import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputConnection;


public class SwipeIMS extends InputMethodService implements KeyboardView.OnKeyboardActionListener {

    @Override
    public View onCreateInputView() {
        KeyboardView keyboardView = (KeyboardView) getLayoutInflater().inflate(R.layout.keyboard_view, null);
        Keyboard keyboard = new Keyboard(this, R.xml.toki_pad_swipe);
        keyboardView.setKeyboard(keyboard);
        keyboardView.setOnKeyboardActionListener(this);
        return keyboardView;
    }

    @Override
    public void onPress(int i) {

    }

    @Override
    public void onRelease(int i) {

    }

    @Override
    public void onText(CharSequence charSequence) {

    }

    @Override
    public void onKey(int primaryCode, int[] keyCodes) {
        InputConnection inputConnection = getCurrentInputConnection();

        if (inputConnection != null) {
            switch(primaryCode) {
                case Keyboard.KEYCODE_DELETE :
                    CharSequence selectedText = inputConnection.getSelectedText(0);

                    if (TextUtils.isEmpty(selectedText)) {
                        inputConnection.deleteSurroundingText(1, 0);
                    } else {
                        inputConnection.commitText("", 1);
                    }

                    break;
                default :
                    char code = (char) primaryCode;
                    inputConnection.commitText(String.valueOf(code), 1);
            }
        }
    }

    @Override
    public void swipeLeft() {
//        InputConnection inputConnection = getCurrentInputConnection();
//        if (inputConnection != null) inputConnection.commitText("i", 1);
    }

    @Override
    public void swipeRight() {
//        InputConnection inputConnection = getCurrentInputConnection();
//        if (inputConnection != null) inputConnection.commitText("e", 1);
    }

    @Override
    public void swipeDown() {
//        InputConnection inputConnection = getCurrentInputConnection();
//        if (inputConnection != null) inputConnection.commitText("o", 1);
    }

    @Override
    public void swipeUp() {
//        InputConnection inputConnection = getCurrentInputConnection();
//        if (inputConnection != null) inputConnection.commitText("u", 1);
    }
}