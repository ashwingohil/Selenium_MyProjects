public class FbSignupTest2 extends FBTestBase{

    //public FbMainPage fbMainPageObject;
    public FbSignUpPage fbSignUpPageObject;

    public static void main(String[] args){

        FbSignupTest2 object = new FbSignupTest2();
        object.DriverInitialization("firefox");
        FbMainPage fbMainPageObject = new FbMainPage(driver);
        driver.get(fbMainPageObject.pageURL);
        fbMainPageObject.clickCreateAccount();

        FbSignUpPage fbSignUpPageObject = new FbSignUpPage(driver);

        try{
            Thread.sleep(3000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
        fbSignUpPageObject.fillFirstName("ashwin");



    }
}

// JUST A CHECK PAGE
