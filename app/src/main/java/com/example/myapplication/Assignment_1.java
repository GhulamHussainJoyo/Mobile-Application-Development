package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.LinkedList;
import java.util.Random;


//    https://random-word-api.herokuapp.com/word?number=10


public class Assignment_1 extends AppCompatActivity {

    //    Data Structures
    LinkedList<Character> counters = new LinkedList<>();
    String[] arr = {"apple", "car", "dog", "kite", "mango", "zabra", "noon", "sunday"};
    char[] letters;
    String word;
    //    Random Library and Libraries
    Random random = new Random();
    static final String TAG = "error of camera";
    String inputUnderLine = "";
    int count = 0;
    int totalAttempts = 5;
    int attempts = 0;


    //    Hooks
    Button newBtn, a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z;
    TextView guessWord, input;
    ImageView hangman;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment_1);

//        initialize Hooks
        newBtn = findViewById(R.id.newBtn);
        hangman = findViewById(R.id.hangman);
        input = findViewById(R.id.input);
        guessWord = findViewById(R.id.guessWord);

        a = findViewById(R.id.a);
        b = findViewById(R.id.b);
        c = findViewById(R.id.c);
        d = findViewById(R.id.d);
        e = findViewById(R.id.e);
        f = findViewById(R.id.f);
        g = findViewById(R.id.g);
        h = findViewById(R.id.h);
        i = findViewById(R.id.i);
        j = findViewById(R.id.j);
        k = findViewById(R.id.k);
        l = findViewById(R.id.l);
        m = findViewById(R.id.m);
        n = findViewById(R.id.n);
        o = findViewById(R.id.o);
        p = findViewById(R.id.p);
        q = findViewById(R.id.q);
        r = findViewById(R.id.r);
        s = findViewById(R.id.s);
        t = findViewById(R.id.t);
        u = findViewById(R.id.u);
        v = findViewById(R.id.v);
        w = findViewById(R.id.w);
        x = findViewById(R.id.x);
        y = findViewById(R.id.y);
        z = findViewById(R.id.z);


        generateRandomLetters();

        newBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newButtonClick();
            }
        });


    }


    public void generateRandomLetters() {
        word = getRandomWord(arr);
        int randInt = random.nextInt(word.length());
        letters = word.toCharArray();

        for (int i = 1; i <= word.length() / 2; i++) {
            int temp1 = (randInt + i) % word.length();
            System.out.println(temp1);
            counters.add(letters[temp1]);
            letters[temp1] = '?';

            count += 1;

        }
        String result = new String(letters);
        guessWord.setText(result);

        for (int i = 0; i < count; i++) {
            inputUnderLine += "_ ";

        }
        input.setText(inputUnderLine);
    }


    public void newButtonClick() {
        inputUnderLine = "";
        counters.clear();
        count = 0;
        totalAttempts = 5;
        attempts = 0;
        word = "";
        letters = null;
        String word;
        hangman.setImageResource(R.mipmap.hangman_1);
        generateRandomLetters();
        setClickAbleButtons();


    }

    public void disableButtons() {
        a.setBackgroundColor(getResources().getColor(R.color.hanBlue));

        a.setClickable(false);
        b.setClickable(false);
        b.setClickable(false);
        c.setClickable(false);
        d.setClickable(false);
        e.setClickable(false);
        f.setClickable(false);
        g.setClickable(false);
        h.setClickable(false);
        i.setClickable(false);
        j.setClickable(false);
        k.setClickable(false);
        l.setClickable(false);
        m.setClickable(false);
        n.setClickable(false);
        o.setClickable(false);
        p.setClickable(false);
        q.setClickable(false);
        r.setClickable(false);
        s.setClickable(false);
        t.setClickable(false);
        u.setClickable(false);
        v.setClickable(false);
        w.setClickable(false);
        x.setClickable(false);
        y.setClickable(false);
        z.setClickable(false);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            a.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.hanBlue));
            a.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.hanBlue));
            b.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.hanBlue));
            b.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.hanBlue));
            c.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.hanBlue));
            d.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.hanBlue));
            e.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.hanBlue));
            f.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.hanBlue));
            g.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.hanBlue));
            h.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.hanBlue));
            i.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.hanBlue));
            j.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.hanBlue));
            k.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.hanBlue));
            l.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.hanBlue));
            m.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.hanBlue));
            n.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.hanBlue));
            o.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.hanBlue));
            p.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.hanBlue));
            q.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.hanBlue));
            r.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.hanBlue));
            s.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.hanBlue));
            t.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.hanBlue));
            u.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.hanBlue));
            v.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.hanBlue));
            w.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.hanBlue));
            x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.hanBlue));
            y.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.hanBlue));
            z.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.hanBlue));
        }
//        .setBackgroundColor();
        a.setBackgroundColor(getResources().getColor(R.color.hanBlue));
        b.setBackgroundColor(getResources().getColor(R.color.hanBlue));
        b.setBackgroundColor(getResources().getColor(R.color.hanBlue));
        c.setBackgroundColor(getResources().getColor(R.color.hanBlue));
        d.setBackgroundColor(getResources().getColor(R.color.hanBlue));
        e.setBackgroundColor(getResources().getColor(R.color.hanBlue));
        f.setBackgroundColor(getResources().getColor(R.color.hanBlue));
        g.setBackgroundColor(getResources().getColor(R.color.hanBlue));
        h.setBackgroundColor(getResources().getColor(R.color.hanBlue));
        i.setBackgroundColor(getResources().getColor(R.color.hanBlue));
        j.setBackgroundColor(getResources().getColor(R.color.hanBlue));
        k.setBackgroundColor(getResources().getColor(R.color.hanBlue));
        l.setBackgroundColor(getResources().getColor(R.color.hanBlue));
        m.setBackgroundColor(getResources().getColor(R.color.hanBlue));
        n.setBackgroundColor(getResources().getColor(R.color.hanBlue));
        o.setBackgroundColor(getResources().getColor(R.color.hanBlue));
        p.setBackgroundColor(getResources().getColor(R.color.hanBlue));
        q.setBackgroundColor(getResources().getColor(R.color.hanBlue));
        r.setBackgroundColor(getResources().getColor(R.color.hanBlue));
        s.setBackgroundColor(getResources().getColor(R.color.hanBlue));
        t.setBackgroundColor(getResources().getColor(R.color.hanBlue));
        u.setBackgroundColor(getResources().getColor(R.color.hanBlue));
        v.setBackgroundColor(getResources().getColor(R.color.hanBlue));
        w.setBackgroundColor(getResources().getColor(R.color.hanBlue));
        x.setBackgroundColor(getResources().getColor(R.color.hanBlue));
        y.setBackgroundColor(getResources().getColor(R.color.hanBlue));
        z.setBackgroundColor(getResources().getColor(R.color.hanBlue));


    }

    public void setClickAbleButtons() {
        a.setClickable(true);
        b.setClickable(true);
        c.setClickable(true);
        d.setClickable(true);
        e.setClickable(true);
        f.setClickable(true);
        g.setClickable(true);
        h.setClickable(true);
        i.setClickable(true);
        j.setClickable(true);
        k.setClickable(true);
        l.setClickable(true);
        m.setClickable(true);
        n.setClickable(true);
        o.setClickable(true);
        p.setClickable(true);
        q.setClickable(true);
        r.setClickable(true);
        s.setClickable(true);
        t.setClickable(true);
        u.setClickable(true);
        v.setClickable(true);
        w.setClickable(true);
        x.setClickable(true);
        y.setClickable(true);
        z.setClickable(true);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            a.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.colorAccent));
            a.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.colorAccent));
            b.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.colorAccent));
            b.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.colorAccent));
            c.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.colorAccent));
            d.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.colorAccent));
            e.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.colorAccent));
            f.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.colorAccent));
            g.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.colorAccent));
            h.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.colorAccent));
            i.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.colorAccent));
            j.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.colorAccent));
            k.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.colorAccent));
            l.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.colorAccent));
            m.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.colorAccent));
            n.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.colorAccent));
            o.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.colorAccent));
            p.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.colorAccent));
            q.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.colorAccent));
            r.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.colorAccent));
            s.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.colorAccent));
            t.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.colorAccent));
            u.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.colorAccent));
            v.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.colorAccent));
            w.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.colorAccent));
            x.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.colorAccent));
            y.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.colorAccent));
            z.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.colorAccent));
        }

        a.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        b.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        b.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        c.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        d.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        e.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        f.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        g.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        h.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        i.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        j.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        k.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        l.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        m.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        n.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        o.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        p.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        q.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        r.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        s.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        t.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        u.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        v.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        w.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        x.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        y.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        z.setBackgroundColor(getResources().getColor(R.color.colorAccent));
    }

    public String getRandomWord(String[] arr) {

        int randNum = random.nextInt(arr.length);
        Log.e(TAG, " " + randNum);
        return arr[randNum];

    }

    public boolean isRemaingAttempts() {
        if (totalAttempts != 0) {
            return true;
        } else
            return false;
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    public void checkLetter(char letter) {


        if (counters.contains(letter)) {
            int iterator = 0;
            int attemptSize = counters.size();

            while (letters[iterator] != '?' && attemptSize >= 0) {
                iterator += 1;

            }
            letters[iterator] = letter;
            String result = new String(letters);
            attemptSize -= 1;

            if (result.equals(word)) {
                char[] tempArray = inputUnderLine.toCharArray();
                tempArray[attempts] = letter;
                String newString = new String(tempArray);

                input.setText(newString);
                inputUnderLine = newString;
                Log.e(TAG, "input under line in if => " + inputUnderLine);
                attempts += 2;
                guessWord.setText("win");
                disableButtons();

            } else {
                char[] tempArray = inputUnderLine.toCharArray();
                tempArray[attempts] = letter;
                String newString = new String(tempArray);

                input.setText(newString);
                inputUnderLine = newString;
                Log.e(TAG, "input under line in else => " + inputUnderLine);
                attempts += 2;

            }


        } else {
//                adding error image to hangman
            if (totalAttempts == 5) {
                hangman.setImageResource(R.mipmap.hangman_2);
            }

            if (totalAttempts == 4) {
                hangman.setImageResource(R.mipmap.hangman_3);

            }

            if (totalAttempts == 3) {
                hangman.setImageResource(R.mipmap.hangman_4);

            }

            if (totalAttempts == 2) {
                hangman.setImageResource(R.mipmap.hangman_5);

            }

            if (totalAttempts == 1) {
                hangman.setImageResource(R.mipmap.hangman_6);

            }

            if (totalAttempts == 0) {
                disableButtons();
            }

            totalAttempts -= 1;

        }


    }

    public void alPhabetClick(View view) {

        if (isRemaingAttempts() == true) {
            switch (view.getId()) {
                case R.id.a:
                    checkLetter('a');
                    break;
                case R.id.b:
                    checkLetter('b');
                    break;
                case R.id.c:
                    checkLetter('c');
                    break;
                case R.id.d:
                    checkLetter('d');
                    break;
                case R.id.e:
                    checkLetter('e');
                    break;

                case R.id.f:
                    checkLetter('f');
                    break;
                case R.id.g:
                    checkLetter('g');
                    break;

                case R.id.h:
                    checkLetter('h');
                    break;
                case R.id.i:
                    checkLetter('i');
                    break;

                case R.id.j:
                    checkLetter('j');
                    break;

                case R.id.k:
                    checkLetter('k');
                    break;

                case R.id.l:
                    checkLetter('l');
                    break;

                case R.id.m:
                    checkLetter('m');
                    break;

                case R.id.n:
                    checkLetter('n');
                    break;

                case R.id.o:
                    checkLetter('o');
                    break;

                case R.id.p:
                    checkLetter('p');
                    break;

                case R.id.q:
                    checkLetter('q');
                    break;

                case R.id.r:
                    checkLetter('r');
                    break;

                case R.id.s:
                    checkLetter('s');
                    break;

                case R.id.t:
                    checkLetter('t');
                    break;

                case R.id.u:
                    checkLetter('u');
                    break;

                case R.id.v:
                    checkLetter('v');
                    break;

                case R.id.w:
                    checkLetter('w');
                    break;

                case R.id.x:
                    checkLetter('x');
                    break;

                case R.id.y:
                    checkLetter('y');
                    break;

                case R.id.z:
                    checkLetter('z');
                    break;


            }
        } else {
            Toast.makeText(this, "else", Toast.LENGTH_LONG).show();
            disableButtons();
            hangman.setImageResource(R.mipmap.hangman_died);
            guessWord.setText("loss");
        }

    }


}

//    static final int REQUEST_IMAGE_CAPTURE = 1;
//        cameraBtn = findViewById(R.id.cameraBtn);
//        cameraImageView = findViewById(R.id.imageFromCamera)
//     @Override
//      protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
//            Bundle extras = data.getExtras();
//            Bitmap imageBitmap = (Bitmap) extras.get("data");
//            cameraImageView.setImageBitmap(imageBitmap);
//        }
//    }

//          cameraBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                try {
//                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
//                } catch (ActivityNotFoundException e) {
//                    Log.e(TAG," "+e);
//                }
//
//            }
//        });