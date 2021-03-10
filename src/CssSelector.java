import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CssSelector {

    WebDriver driver;
    String parentWindow = null;
    String childWindow = null;


    public CssSelector(){
        System.setProperty("webdriver.gecko.driver","/home/ashwin/IdeaProjects/Selenium-MyProjects/DEPENDENCIES/geckodriver");
        driver = new FirefoxDriver();

        //System.setProperty("webdriver.chrome.driver","/home/ashwin/IdeaProjects/Selenium-MyProjects/DEPENDENCIES/chromedriver");
        //driver = new ChromeDriver();
    }


    public void switchToPopUp(){

        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();
        for(String h : handles){
            System.out.println("Handle: "+h);
        }
        int i=0;
        while(it.hasNext()){
            if(i == 0) {
                parentWindow = it.next();
            }
            childWindow = it.next();
            i++;
        }

        System.out.println(parentWindow);
        System.out.println(childWindow);
        driver.switchTo().window(childWindow);
    }

    public void css1(){

        //open wordpress.com and inspect login link on top right

        driver.get("https://wordpress.com/");
        WebElement loginButton = driver.findElement(By.cssSelector(".x-nav-list--right>.x-nav-item--wide>.x-link"));

        //Below is the correct verbose way to find the element
        //"ul.x-nav-list.x-nav-list--right>li.x-nav-item.x-nav-item--wide>a.x-nav-link.x-link"
        //The above will also work

        //.x-nav-list.x-nav-list--right>li.x-nav-item.x-nav-item--wide>a.x-nav-link.x-link
        //This will also work.

        //.x-nav-list.x-nav-list--right>.x-nav-item.x-nav-item--wide>.x-nav-link.x-link
        //Removing all the html tag values and keeping classes with . will also work

        //ul.x-nav-list--right>li.x-nav-item--wide>a.x-link
        //This will work. keeping all the last classes in the chain with html tag

        //.x-nav-list--right>.x-nav-item--wide>.x-link
        //this will work. removing all the html tags but then keep the right most(last class in the chain)

        loginButton.click();

        try{
            Thread.sleep(5000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }

        WebElement continueWithGoogle = driver.findElement(By.cssSelector("button.social-buttons__button.button:nth-child(1)>span.social-buttons__service-name"));
        continueWithGoogle.click();
        //see for continueWithGoogle
        /*
        There is <button
                   <svg
                       <span
        So I can even take this though no various <svg child. But button.class:nth-child(1)>span.class
         */
        try{
            Thread.sleep(5000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }

        switchToPopUp();

        WebElement email = driver.findElement(By.cssSelector("input[id='identifierId'][type='email']"));
        email.sendKeys("ashwin.k.gohil@gmail.com");
        //#identifierId  //will also do
        //input#identifierId //will also do

        WebElement clickNext1 = driver.findElement(By.cssSelector("div.VfPpkd-RLmnJb"));
        clickNext1.click();
        //this one is simple a div element which is not under tree and attribute class

        try{
            Thread.sleep(5000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }

        WebElement password = driver.findElement(By.cssSelector("input[type = 'password']"));
        password.sendKeys("yourpassword");
        //input.class will also do

        WebElement clickNext2 = driver.findElement(By.cssSelector("div.VfPpkd-RLmnJb"));
        clickNext2.click();

        driver.switchTo().window(parentWindow);
        String handle = driver.getWindowHandle();
        System.out.println(handle);
        driver.switchTo().window(handle);

        try{
            Thread.sleep(10000); //this works
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }




        WebElement siteLink = driver.findElement(By.cssSelector("ul.sidebar__menu:nth-child(2) > li:nth-child(1) > h2:nth-child(1) > svg:nth-child(3)"));
        siteLink.click();
        //ul.sidebar__menu:nth-child(2)>li:nth-child(1)>h2:nth-child(1)>span.sidebar__expandable-title
        //div.sidebar__menu-wrapper>ul.sidebar__menu:nth-child(2)>li:nth-child(1)>h2:nth-child(1)>span.sidebar__expandable-title
        //default
        //ul.sidebar__menu:nth-child(2) > li:nth-child(1) > h2:nth-child(1) > span:nth-child(2)


        //MY OWN FORMATIONS. LEARN IT
        //ul.sidebar__menu:nth-child(2)>li>h2.sidebar__heading>span.sidebar__expandable-title
        //div.sidebar__menu-wrapper>ul:nth-of-type(2)>li:nth-child(1)>h2:nth-child(1)>span.sidebar__expandable-title

        /*
        THIS IS TRICKY. UNDERSTAND IT AGAIN
        ALWAYS WRITE THE QUERY IN INSPECTOR SEARCH BAR AND CHECK THE STATUS AS 1 of 1 or 1 of 3. This way you
        will know
        OBSERVE
        Look for the tags around this element. you will see ul (various ul)
        So, ul.sidebar__menu . paste on inspect search and press enter that element will be highlighter
        Now ul.sidebar__menu:nth-child(1) will still be at same element
        so type ul.sidebar__menu:nth-child(2) and press enter. It will highlight 2nd element 2nd child

        Now we are at the required node, now we traverse. so ul.sidebar__menu:nth-child(2)>li
        Here ul.sidebar__menu:nth-child(2)>li [it will highlight next element in that node]
        Now do ul.sidebar__menu:nth-child(2)>li>h2.sidebar__heading  [it will highlight respective element, one down]
        Like this traverse, ul.sidebar__menu:nth-child(2)>li>h2.sidebar__heading>span.sidebar__expandable-title

        Now,
        type div.sidebar__menu-wrapper>ul:first-of-type
        type div.sidebar__menu-wrapper>ul:last-of-type
        type div.sidebar__menu-wrapper>ul:nth-of-type(2)

        When we reach to this element @ this point, i can use either traverse method as above
        or nth-child concept of each such ul. @every ul, i can go through the mechanism of nth-child
            div.sidebar__menu-wrapper>ul:nth-of-type(2)>li:nth-child(1)>h2:nth-child(1)>span [this will highlight what is required]
        OR include the class of span too. That is
            div.sidebar__menu-wrapper>ul:nth-of-type(2)>li:nth-child(1)>h2:nth-child(1)>span..sidebar__expandable-title
        Here li:nth-child leads to h2 which h2:nth-child leads to span and then >span.class

        DIFFERENCE FROM ABOVE TWO FORMATIONS (my own)
        When you see many same type of nodes starting with element(those arrows for each node)
        you can go to any of them by nth-child and then simple traverse
        Or you can also but starting from the highest node of many childs, you can do nth-of-type
        and then traverse on the required node with nth child concept too and traversing too
        when picking up directly child nodes from the many, you refer with nth-child
        but picking up from the parent above all child nodes, u do nth-of-type

        */

        try{
            Thread.sleep(2000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
        WebElement postsLink = driver.findElement(By.cssSelector("li#menu33>ul>li:nth-child(2)>a.sidebar__menu-link>span.sidebar__menu-link-text"));
        postsLink.click();

        //My own formation
        //li#menu33>ul>li:nth-child(2)>a.sidebar__menu-link>span.sidebar__menu-link-text
        /*
        Note that first catch could have been li but ul was many occurrences. Pick the first as
        unique and traverse
        Always try the first-of-type and last-of-type to get the idea which can lead to nthchild too


        .side-menu-post > a:nth-child(1) > span:nth-child(1)
        This is default generated
         */
        try{
            Thread.sleep(2000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
        WebElement addNewPostLink = driver.findElement(By.cssSelector("div.post-type-list>div:nth-of-type(1)>div:nth-child(2)>a.button"));
        addNewPostLink.click();

        //my own formation. good example
        // div.post-type-list>div:nth-of-type(1)>div:nth-child(2)>a.button

        String frameurl = "https://pwnmojo.wordpress.com/wp-admin/post-new.php?calypsoify=1&block-editor=1&frame-nonce=27e867cd49&origin=https%3A%2F%2Fwordpress.com&environment-id=production&support_user&_support_token";
        driver.get(frameurl);

        try{
            Thread.sleep(5000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }

        WebElement addtitleLink = driver.findElement(By.cssSelector("textarea#post-title-0"));
        addtitleLink.sendKeys("checking css");

        //textarea#post-title-0

        try{
            Thread.sleep(5000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }

        WebElement publish1 = driver.findElement(By.cssSelector("div.edit-post-header__settings>button"));
        //div.edit-post-header__settings>button
        /*
        this one is important. directly button.classes(bunch) is not giving that element.
        So move up the tree and trace from some element. Here under one node, there are various different
        elements. I dont need to go > > > through all of them. I can directly jump by > element but the route
        to that node has to be established
         */
        publish1.click();

        try{
            Thread.sleep(5000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }

        WebElement publish2 = driver.findElement(By.cssSelector("div.editor-post-publish-panel__header-publish-button>button"));
        publish2.click();

        try{
            Thread.sleep(3000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }

        driver.navigate().back();
        try{
            Thread.sleep(5000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
        driver.navigate().back();

        try{
            Thread.sleep(10000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }

        selectPostTitle("checking css");

    }


    public void selectPostTitle(String posttitle){

        List<WebElement> posttitlelist  =  driver.findElements(By.cssSelector("div.post-type-list>div.post-item"));
        //this is a step above the real element. if i narrow more i will still get unique <a> tag with
        //post title string. here i get posttitle string but some more text("seconds ago text). so
        // use string.contains
        //Below for loops are taking appropriate findElements. The script is unstable because if after
        //some time fetches the frame link cos I am doing in frameUrl(reopening the url in get)
        //populate 2-3 "css selector" post tile by commenting //selectPostTitle()

        for(WebElement eachpost: posttitlelist){
            System.out.println(eachpost.getText());
        }

        for(WebElement eachpost : posttitlelist){
            System.out.println("outside each post");
            if(eachpost.getText().contains(posttitle)){
                System.out.println("inside each post");
                Actions builder = new Actions(driver);
                builder.moveToElement(eachpost); //important very
                WebElement dottedMenu = driver.findElement(By.cssSelector("div.post-actions-ellipsis-menu>span>button"));
                builder.click(dottedMenu);

                Action compositeAction = builder.build();
                compositeAction.perform();

                try{
                    Thread.sleep(3000);
                }catch(InterruptedException ex){
                    ex.printStackTrace();
                }

                List<WebElement> pop = driver.findElements(By.cssSelector("button.popover__menu-item"));
                for(WebElement pops : pop){

                    if(pops.getText().equals("Trash")){
                        System.out.println("inside pop");
                        Actions popbuilder = new Actions(driver);
                        builder.moveToElement(pops);
                        builder.click();
                        Action compositeAction2 = builder.build();
                        compositeAction2.perform();
                        break;
                    }
                }
            }
        }



    }

    public static void main(String[] args){
        CssSelector object = new CssSelector();
        object.css1();
    }




}
