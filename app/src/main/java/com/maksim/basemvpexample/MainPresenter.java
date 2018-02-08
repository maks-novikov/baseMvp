package com.maksim.basemvpexample;

/**
 * Created by Maksim Novikov on 08-Feb-18.
 */

public class MainPresenter {

    private MainView mView;
    private UserRepository mUserRepo;


    public void initInfo(){
        String name = mUserRepo.getName();
        String age = mUserRepo.getAge();
        if(name != null){
            mView.setUserTv(name+" is "+age+ " years old");
        }else{
            mView.setUserTv("add new user please");
        }
    }

    public void updateUser(String name, String age){
        mUserRepo.setName(name);
        mUserRepo.setAge(age);
        initInfo();
    }


    public void attachView(MainView view){
        mView = view;
        mUserRepo = UserRepository.getInstance(mView.getContext());
        initInfo();
    }

    public void detachView(){
        mView = null;
    }

}
