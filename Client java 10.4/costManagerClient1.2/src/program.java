import models.Model;
import view.View;
import viewModel.ViewModel;

import javax.swing.*;

public class program {
    public static void main(String[] args) {

        Model model = new Model();
        ViewModel vm = new ViewModel();
        View view = new View();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                view.init();
                view.start();
            }
        });
        vm.setModel(model);
        vm.setView(view);
        view.setIViewModel(vm);
    }
}
