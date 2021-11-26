package com.example.chatapp.Notifications;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class MyFirebaseIdService extends FirebaseInstanceIdService {
    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        FirebaseUser firebaseUser= FirebaseAuth.getInstance().getCurrentUser();

        String refreshToken= FirebaseInstanceId.getInstance().getToken();
        if(firebaseUser!=null)
        {
            updateToken(refreshToken);
        }
    }

    private void updateToken(String refreshToken) {
        FirebaseUser firebaseUser=FirebaseAuth.getInstance().getCurrentUser();
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://chatapp-5e6bc-default-rtdb.firebaseio.com/");
        DatabaseReference reference= database.getReference("Tokens");
        Token token=new Token(refreshToken);
        reference.child(firebaseUser.getUid()).setValue(token);
    }
}
