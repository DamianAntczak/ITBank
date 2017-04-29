package CommandHandler;

import Command.Command;
import Command.TransferCommand;
import CommandHandler.BankCommandHandler;
import Product.BankAccount;
import Product.IProduct;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by marcinkarmelita on 28/04/17.
 */
@RunWith(Parameterized.class)
public class BankCommandHandlerTest {
    private IProduct from;
    private IProduct to;

    private BankCommandHandler fixture;
    private Command command;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new BankAccount(""), new BankAccount("")},
                {new BankAccount(""), new BankAccount("")}
        });
    }

    public BankCommandHandlerTest(IProduct from, IProduct to) {
        this.from = from;
        this.to = to;
        this.from.addCash(500.0);
        this.command = new TransferCommand(from, to, 200.0);
    }

    @Before
    public void setUp() throws Exception {
        fixture = new BankCommandHandler();
    }

    @Test
    public void getCommands() throws Exception {

    }

    @Test
    public void handleInternalCommand() throws Exception {
        fixture.handle(command);
        Assert.assertTrue(fixture.getExternalCommands().isEmpty());
    }

    @Test
    public void handleExternalCommand() throws Exception {
        // TODO: 29/04/17 (MK): Handle external commands
//        fixture.handle(command);
//        Assert.assertTrue(fixture.getExternalCommands().size() == 1);
    }

    @Test
    public void getExternalOperations() throws Exception {

    }

}