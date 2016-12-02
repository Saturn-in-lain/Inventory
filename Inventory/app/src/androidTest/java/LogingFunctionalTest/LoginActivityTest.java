package LogingFunctionalTest;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.inventory.echostar.inventory.R;
import com.inventory.echostar.inventory.login.LoginActivity;

/**
 * Created by stas.savinov on 12/2/2016.
 */

public class LoginActivityTest extends ActivityInstrumentationTestCase2<LoginActivity>
{
    public LoginActivityTest()
    {
        super(LoginActivity.class);
    }

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
    }

    @SmallTest
    public void testLoginFieldExist()
    {
        EditText edtTxtUserName = (EditText) getActivity().findViewById(R.id.edtxtName);
        assertNotNull(edtTxtUserName);
    }

    @SmallTest
    public void testPasswordFieldExist()
    {
        EditText edtTxtPassword = (EditText) getActivity().findViewById(R.id.edtxtPassword);
        assertNotNull(edtTxtPassword);
    }

    @SmallTest
    public void testButtonSignInExist()
    {
        Button btnLogging = (Button) getActivity().findViewById(R.id.btnLogging);
        assertNotNull(btnLogging);
    }

    @SmallTest
    public void testRememberMeCheckExist()
    {
        CheckBox chkbxRememberMe = (CheckBox) getActivity().findViewById(R.id.chBxRememberMe);
        assertNotNull(chkbxRememberMe);
    }

    @SmallTest
    public void testIsUsernameNotEmpty()
    {
        String username = getActivity().getUsername();
        assertEquals(false,(0 == username.length()));
    }

    @Override
    protected void tearDown() throws Exception
    {
        super.tearDown();
    }
}
