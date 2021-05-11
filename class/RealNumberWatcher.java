import android.annotation.SuppressLint;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class RealNumberWatcher implements TextWatcher {
    private final EditText editText;
    private char separator = ',';
    
    /**
     * Decimal-Signed inputType TextWatcher with thousands separator adding automatically
     * @param editText EditText object
     */
    public RealNumberWatcher(EditText editText) {
        this.editText = editText;
    }

    /**
     * Decimal-Signed inputType TextWatcher with thousands separator adding automatically
     * @param editText EditText object
     * @param separator Thousands separator character (default ',')
     */
    public RealNumberWatcher(EditText editText, char separator) {
        this.editText = editText;
        this.separator = separator;
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
            if (inputStr.charAt(i) != separator) {
                realCursorPosition += 1;
            }
        }

        // re-draw separator ","
        String postText = inputStr.replaceAll(String.valueOf(separator), "");
        int dotPosition = postText.concat(".").indexOf('.');
        int offsetForSeparator = (postText.indexOf('-') != -1) ? 2 : 1;
        for (int i = 0; i < (dotPosition - offsetForSeparator) / 3; i++) {
            postText = new StringBuilder(postText)
                    .insert(dotPosition - (i+1)*3, separator).toString();
        }

        // update cursor position
        int cursorPosition = 0;
        for (int i = 0; i < realCursorPosition; i++) {
            if (postText.charAt(cursorPosition) == separator) {
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
