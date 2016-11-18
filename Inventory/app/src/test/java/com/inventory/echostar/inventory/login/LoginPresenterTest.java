package com.inventory.echostar.inventory.login;

/**
 * Created by stas.savinov on 11/17/2016.
 */

import android.util.Log;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


import com.inventory.echostar.inventory.R;

import database_manager.DatabaseOpenHelper;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;

@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest
{
    @Mock
    private LoginView view;

    @Mock
    private LoggingRequest service;
    private LoginPresenter presenter;

    @Before
    public void setUp() throws Exception
    {
        presenter = new LoginPresenter(view);
    }

    @Test
    public void shouldShowErrorMessageWhenUsernameIsEmpty() throws Exception
    {
        when(view.getUsername()).thenReturn("");
        presenter.onLoginClicked();
        verify(view).showUsernameError(R.string.username_error);
    }

    @Test
    public void shouldShowErrorMessageWhenPasswordIsEmpty() throws Exception
    {
        when(view.getUsername()).thenReturn("stas.savinov");
        when(view.getPassword()).thenReturn("");
        presenter.onLoginClicked();

        verify(view).showPasswordError(R.string.password_error);
    }

    /*
    * @Test: shouldStartMainActivityWhenUsernameAndPasswordAreCorrect
    * @Description:
    * @Note: Currently does not work because no need to mock up calls to local database
    * */
    @Test
    public void shouldStartMainActivityWhenUsernameAndPasswordAreCorrect() throws Exception {
        when(view.getUsername()).thenReturn("stas.savinov");
        when(view.getPassword()).thenReturn("123456");

        DatabaseOpenHelper database = new DatabaseOpenHelper(view.getLoginViewContext());

        when(presenter.ConnectToLocalAuthorizatioinDatabase("stas.savinov", "123456", database)).thenReturn(true);
        presenter.onLoginClicked();
        verify(view).startMainActivity();
    }

    /*
    * @Test: shouldShowLoginErrorWhenUsernameAndPasswordAreInvalid
    * @Description:
    * @Note: Currently does not work because no need to mock up calls to local database
    * */
    @Test
    public void shouldShowLoginErrorWhenUsernameAndPasswordAreInvalid() throws Exception {
        when(view.getUsername()).thenReturn("james");
        when(view.getPassword()).thenReturn("bond");
        DatabaseOpenHelper database = new DatabaseOpenHelper(view.getLoginViewContext());
        when(presenter.ConnectToLocalAuthorizatioinDatabase("james","bond",database)).thenReturn(true);
        presenter.onLoginClicked();

        verify(view).showLoginError(R.string.login_failed);
    }
}
