private static final int BACK_INTERVAL = 2000;
long mBack = System.currentTimeMillis();

@Override
public void onBackPressed() {
    if (System.currentTimeMillis() < mBack + BACK_INTERVAL) {
        super.onBackPressed();
    }
    else {
        Toast.makeText(MainActivity.this, "Press Back again to exit", Toast.LENGTH_SHORT).show();
        mBack = System.currentTimeMillis();
    }
}