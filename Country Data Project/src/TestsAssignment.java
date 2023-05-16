import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.Arrays;

import java.util.Scanner;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.Arrays;

import java.util.Scanner;

public class TestsAssignment {

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
  }

  @Test
  public void testMin() {
	int[] years= {1,2,3,4,5};
    double[][] values = { { 28.14971007, 28.98916968, 28.70592263, 28.77157013, 29.27456382 },
        { 36.81818182, 36.81818182, 30.45454545, 30.454, 4545 }, { 18.77984085, 19.27561399, 18.88402121 },
        { 36.36363636 }, { 49, 49, 56, 60, 7 } };
    Country myCountry = new Country("Utopia","Something something",years, values[0]);

    double[] actuals = new double[5];
    double[] expecteds = { 28.14971007, 30.454, 18.77984085, 36.36363636, 7.0 };
    String[] arrays = new String[5];
    for (int i = 0; i < values.length; i++) {
      myCountry.setData(values[i]);
      actuals[i] = myCountry.min();
      arrays[i] = Arrays.toString(values[i]) + "\n";

    }
    String msg = String.format("For min %s", Arrays.toString(arrays));
    assertEquals(msg, Arrays.toString(expecteds), Arrays.toString(actuals));
  }

  @Test
  public void testMax() {
    double[][] values = { { 28.14971007, 28.98916968, 28.70592263, 28.77157013, 29.27456382 },
        { 36.81818182, 36.81818182, 30.45454545, 30.454, 4545 }, { 18.77984085, 19.27561399, 18.88402121 },
        { 36.36363636 }, { 49, 49, 56, 60, 7 } };
    int[] years= {1,2,3,4,5};
    Country myCountry = new Country("Utopia","Something something",years, values[0]);

    double[] actuals = new double[5];
    double[] expecteds = { 29.27456382, 4545.0, 19.27561399, 36.36363636, 60.0 };

    String[] arrays = new String[5];
    for (int i = 0; i < values.length; i++) {
      myCountry.setData(values[i]);
      actuals[i] = myCountry.max();
      arrays[i] = Arrays.toString(values[i]) + "\n";
    }

    String msg = String.format("For max %s", Arrays.toString(arrays));
    assertEquals(msg, Arrays.toString(expecteds), Arrays.toString(actuals));
  }

  @Test
  public void countryConstructorTest() {
    int[] years = {2021,2022,2023,2024,2025};
    double[] data = { 36.81818182, 36.81818182, 30.45454545, 30.454, 4545 };
    Country myCountry = new Country("Utopia","Something about somethingElse (in years)",years, data);
    assertEquals("Testing getter of the name of the country", "Utopia", myCountry.getCountry());
    assertEquals("Testing getter of the series of the country", "Something about somethingElse ", myCountry.getSeries());
    assertEquals("Testing getter of the years of the country", Arrays.toString(years), Arrays.toString(myCountry.getYears()));
    assertEquals("Testing getter of the data of the country", Arrays.toString(data), Arrays.toString(myCountry.getData()));
  }

  @Test
  public void getUnitsTest() {
    String[] values = { "Mobile cellular subscriptions (per 100 people)","Gross domestic Product growth (annual %)","Annual freshwater withdrawals, industry (% of total freshwater withdrawal)","Proportion of seats held by women in national parliaments (%)","Mobile cellular subscriptions"};
    int[] years = {2021,2022,2023,2024,2025};
    double[] val = {021,2022,2023,2024,2025};
    Country myCountry = new Country("Utopia","something something",years, val);

    String[] actuals = new String[5];
    String[] expecteds = { "per 100 people", "annual %", "% of total freshwater withdrawal", "%", "" };

    String[] arrays = new String[5];
    for (int i = 0; i < values.length; i++) {
      myCountry.setSeries(values[i]);
      actuals[i] = myCountry.getUnits();
      arrays[i] = values[i] + "\n";
    }

    String msg = String.format("For getUnits %s", Arrays.toString(arrays));
    assertEquals(msg, Arrays.toString(expecteds), Arrays.toString(actuals));
  }

  @Test
  public void getAcronymTest() {
    String[] values = {"Mobile cellular subscriptions (per 100 people)","Gross domestic Product growth (annual %)","Annual freshwater withdrawals, industry (% of total freshwater withdrawal)","Proportion of seats held by women in national parliaments (%)","Mobile cellular subscriptions"};
    int[] years = {2021,2022,2023,2024,2025};
    double[] val = {021,2022,2023,2024,2025};
    Country myCountry = new Country("Utopia","something something",years, val);

    String[] actuals = new String[5];
    String[] expecteds = { "MCS", "GDPG", "AFWI", "PSHWNP","MCS" };

    String[] arrays = new String[5];
    for (int i = 0; i < values.length; i++) {
      myCountry.setSeries(values[i]);
      //System.out.println(values[i]);
      actuals[i] = myCountry.getAcronym();
      //System.out.println(actuals[i]);
      arrays[i] = values[i] + "\n";
    }

    String msg = String.format("For getAcronym %s", Arrays.toString(arrays));
    assertEquals(msg, Arrays.toString(expecteds), Arrays.toString(actuals));
  }

  @Test
  public void getTrendTest() {
    double[][] values = { { 28.14971007, 28.98916968, 29.70592263, 30.77157013, 31.27456382 },
        { 36.81818182, 36.80818181, 30.45454545, 30.354, 29 }, { 18.77984085, 19.27561399, 18.88402121 },
        { 36.36363636,36.36363636 }, { 49, 49, 56, 60, 7 } };
    int[] years = {2021,2022,2023,2024,2025};

    Country myCountry = new Country("Utopia","Mobile cellular subscriptions (per 100 people)",years, values[0]);

    String[] actuals = new String[5];
    String[] expecteds = { "up","down","no trend","no trend","no trend" };

    String[] arrays = new String[5];
    for (int i = 0; i < values.length; i++) {
      myCountry.setData(values[i]);
      actuals[i] = myCountry.getTrend();
      arrays[i] = Arrays.toString(values[i]) + "\n";
  }
     String msg = String.format("For getTrend %s", Arrays.toString(arrays));
    assertEquals(msg, Arrays.toString(expecteds), Arrays.toString(actuals));
  }

  
}