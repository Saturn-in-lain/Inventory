package com.inventory.echostar.inventory.search;

/**
 * Created by stas.savinov on 11/22/2016.
 */

import android.util.Log;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@PrepareForTest(Log.class)
public class SearchPresenterTes
{
    @Mock
    private SearchView view;
    @Mock
    private SearchPresenter presenter;

    @Before
    public void setUp() throws Exception
    {
        presenter = new SearchPresenter(view);
    }

    @Test
    public void testSetSearchString() throws Exception
    {
        String testString = "data";
        presenter.setSearchField(testString);
        assertEquals(testString, presenter.SearchField);
    }

    @Test
    public void testSetItemsFieldString() throws Exception
    {
        String testString = "data";
        presenter.setItemFields(testString);
        assertEquals(testString, presenter.ItemsField);
    }

    @Test
    public void testSetSubCategoryString() throws Exception
    {
        String testString = "data";
        presenter.setSubCategory(testString);
        assertEquals(testString, presenter.SubCategory);
    }

    @Test
    public void testSetCategoryString() throws Exception
    {
        String testString = "data";
        presenter.setCategory(testString);
        assertEquals(testString, presenter.Category);
    }
}
