package stepdefinitions;

import Model.AddToCart;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class PlaceOrderAsGuestSteps {


    AddToCart addToCart = new AddToCart();
    @Given("Mike on home page after opening nopCart mobile app")
    public void MikeOpeningNopCartMobileApp() throws Exception {

        addToCart.openApp();
    }

    @When("Mike click electronics from OUR CATEGORIES list from home page")
    public void MikeClickCategoeryListFromHomePage() throws Exception {
        addToCart.findElectronics();

    }
    @And("Mike click to Mattress Bedroom product details page")
    public void MikeClickProductDetailsPage() throws Exception{

        addToCart.addMattressBedroom();

    }
    @And("Mike click plus button to increase Qty by 2")
    public void MikeIncreaseQuantity() throws Exception{

        addToCart.addQuantity();

    }
    @Then("Mike click add to cart button to add the product in his cart")
    public void MikeClickAddToTheCart() throws Exception{

        addToCart.clickOnCartButton();

    }

    @When("Mike click checkout button from shopping cart page")
    public void MikeClickCheckoutButton()throws Exception{

        addToCart.clickCheckoutFromShoppingCart();

    }
    @And("Mike select checkout as guest from shopping cart page")
    public void MikeSelectCheckoutAsGuest()throws Exception{
        addToCart.selectGuest();

    }
    @Then("Mike input all the details in checkout billing details page and click continue")
    public void MikeInPutAllDetailsAndClickContinue()throws Exception{

        addToCart.inputInformation();

    }
    @And("Mike select Next Day Air as shipping method and click continue")
    public void MikeSelectShippingMethod() throws Exception{

        addToCart.selectShippingOption();

    }

    @And("Mike select Check/Money Order as payment method and click continue")
    public void MikeSelectPaymentMethod() throws Exception{

        addToCart.selectPaymentOption();

    }

    @Then("Mike click confirm button to place the order")
    public void MikeClickConfirmButton() throws Exception{

        addToCart.goToConfirm();

    }
    @And("Verify order place successfully with popup message Your order has been successfully processed!")
    public void MikePlacedOrderSuccessfully() throws Exception{

        addToCart.showSuccessModal();

    }

}
