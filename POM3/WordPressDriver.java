import org.testng.annotations.Test;

public class WordPressDriver extends WordPressTestBase {


    @Test(priority = 0)
    public void init(){
        WordPressDriver object = new WordPressDriver();
        object.InitializeDriver("firefox");

        WordPressHomePage homePage = new WordPressHomePage(driver);
        WordPressLoginPage loginPage = homePage.clickLoginButton();

        loginPage.waitForContinueWithEmail();
        loginPage.clickContinueWithGoogle();
        loginPage.switchToPopUp();
        loginPage.setUsername("ashwin.k.gohil@gmail.com");
        loginPage.clickNext();
        loginPage.setPassword("yourpassword");
        loginPage.clickNext2();

        WordPressUserPage userPage = loginPage.getUserPage();
        userPage.clickSiteLink();
        userPage.clickPostsLink();

        AllPostsPage allPostPage = userPage.getAllPostPage();
        AddNewPostPage addNewPost = allPostPage.getAddNewPostPage();
        allPostPage.clickANewPost();
        addNewPost.addAPost("whoami","localhost");
    }




}
