package me.danielhartman.skillstest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

import android.content.Context;
import android.test.mock.MockContext;
import android.text.Editable;
import android.widget.EditText;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FragmentOnePresenterTest {

    FragmentOnePresenter presenter;
    Context mockContext;

    @Before
    public void setup(){
        presenter = new FragmentOnePresenter();
        mockContext = new MockContext();
    }

    @Test
    public void getTextFromEditText_Returns_Text_WithGoodText(){
        EditText testView = mock(EditText.class);
        Editable editable = mock(Editable.class);
        when(testView.getText()).thenReturn(editable);
        when(editable.toString()).thenReturn("123");
        assertEquals((long)presenter.getTextFromEditText(testView),123);
    }

    @Test
    public void getTextFromEditText_Returns_Null_WithNullInput(){
        EditText testView = null;
        assertNull(presenter.getTextFromEditText(testView));
    }

    @Test
    public void getRandomNumber(){
        for (int i=0; i<10; i++) {
            int randomNumber = presenter.getRandomInt();
            assertTrue(randomNumber <= 9 && randomNumber >= 0);
        }
    }




}