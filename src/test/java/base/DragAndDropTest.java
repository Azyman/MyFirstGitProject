package base;

import org.testng.annotations.Test;
import pages_package.DragAndDrop;

@Test
public class DragAndDropTest extends BaseTests{
    public void DragFrom_boxA_to_boxB_Test(){
        DragAndDrop dragAndDrop = homePage.ClickOnDragAndDrop("Drag and Drop");
        dragAndDrop.DragFrom_boxA_to_boxB();
    }
}
