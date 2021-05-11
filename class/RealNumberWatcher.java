import android.annotation.SuppressLint;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class RealNumberWatcher implements TextWatcher {
    private final EditText editText;

    /**
     * Decimal-Signed inputType TextWatcher with separator adding automatically
     * @param editText EditText object
     */
    public RealNumberWatcher(EditText editText) {
        this.editText = editText;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        String inputStr = s.toString();

        // get cursor position without adding separator
        int realCursorPosition = 0;
        for (int i = 0; i < start + count; i++) {
            if (inputStr.charAt(i) != ',') {
                realCursorPosition += 1;
            }
        }

        // re-draw separator ","
        String postText = inputStr.replaceAll(",", "");
        int dotPosition = postText.concat(".").indexOf('.');
        int offsetForSeparator = (postText.indexOf('-') != -1) ? 2 : 1;
        for (int i = 0; i < (dotPosition - offsetForSeparator) / 3; i++) {
            postText = new StringBuilder(postText)
                    .insert(dotPosition - (i+1)*3, ",").toString();
        }

        // update cursor position
        int cursorPosition = 0;
        for (int i = 0; i < realCursorPosition; i++) {
            if (postText.charAt(cursorPosition) == ',') {
                cursorPosition += 1;
            }
            cursorPosition += 1;
        }

        this.editText.removeTextChangedListener(this);
        this.editText.setText(postText);
        this.editText.setSelection(cursorPosition);
        this.editText.addTextChangedListener(this);
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
