package com.example.cardstack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import link.fls.swipestack.SwipeStack;

public class MainActivity extends AppCompatActivity {

    private SwipeStack cardStack;
    private CardsAdapter cardsAdapter;
    private ArrayList<CardItem> cardItems;
    private View btnCancel;
    private View btnLove;
    private int currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cardStack = (SwipeStack) findViewById(R.id.container);


        setCardStackAdapter();
        currentPosition = 0;

        //Handling swipe event of Cards stack
        cardStack.setListener(new SwipeStack.SwipeStackListener() {
            @Override
            public void onViewSwipedToLeft(int position) {
                currentPosition = position + 1;
            }

            @Override
            public void onViewSwipedToRight(int position) {
                currentPosition = position + 1;
            }

            @Override
            public void onStackEmpty() {

            }
        });

//        btnCancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                cardStack.swipeTopViewToRight();
//            }
//        });
//
//        btnLove.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, "You liked " + cardItems.get(currentPosition).getName(),
//                        Toast.LENGTH_SHORT).show();
//                cardStack.swipeTopViewToLeft();
//            }
//        });
    }

    private void setCardStackAdapter() {
        cardItems = new ArrayList<>();

        cardItems.add(new CardItem(R.drawable.kriti, "Huyen My", "Hanoi"));
        cardItems.add(new CardItem(R.drawable.kareena, "Do Ha", "Nghe An"));
        cardItems.add(new CardItem(R.drawable.mounii, "Dong Nhi", "Hue"));
        cardItems.add(new CardItem(R.drawable.alya, "Le Quyen", "Sai Gon"));
        cardItems.add(new CardItem(R.drawable.zareen, "Phuong Linh", "Thanh Hoa"));
        cardItems.add(new CardItem(R.drawable.jenni, "Phuong Vy", "Hanoi"));
        cardItems.add(new CardItem(R.drawable.shilpa, "Ha Ho", "Da Nang"));

        cardsAdapter = new CardsAdapter(this, cardItems);
        cardStack.setAdapter(cardsAdapter);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if (item.getItemId() == R.id.reset) {
//            cardStack.resetStack();
//        }
//        return super.onOptionsItemSelected(item);
//    }
}