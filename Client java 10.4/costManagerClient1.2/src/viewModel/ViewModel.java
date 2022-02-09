package viewModel;

import models.*;
import view.View;

import javax.swing.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ViewModel implements IViewModel {

    private Model model;
    private View view;
    private ExecutorService service;

    public ViewModel()  {
        this.service = Executors.newFixedThreadPool(3);
    }

    /**
     * Instance of View.
     * @param view the view
     */
    @Override
    public void setView(View view) {
        this.view = view;
    }

    /**
     * Instance of Model.
     * @param model the model
     */
    @Override
    public void setModel(Model model) {
        this.model = model;
    }

    /**
     * Add new user to the DB
     * @param user the user
     */
    @Override
    public void addItem(User user) {
        service.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    String answer = model.postNewUser(user); // add user
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            view.showMessage(answer);
                            //view.showItems(items);
                        }
                    });
                } catch (Exception e) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            view.showMessage("Error");
                        }
                    });
                }
            }
        });
    }

    /**
     * Check if user is Exists.
     * if user Exists display the cost UI.
     * @param user the user
     */
    @Override
    public void checkLogin(User user) {
        service.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    String answer = model.checkLogin(user);
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            Boolean status = true;
                            view.showMessage2(answer);
                            String falseString = "false";
                            Boolean statusAnswer = answer.equals(falseString);
                            System.out.println("Answer is : " + answer + " Status " + statusAnswer);
                            if (statusAnswer == false) { // check if login sucess - display costs view
                                Model modelCost = new Model();
                                ViewModel costViewModel = new ViewModel();
                                View costViewN = new View(answer);
                                SwingUtilities.invokeLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        costViewN.initCost();
                                        costViewN.startCost();
                                    }
                                });
                                costViewModel.setModel(modelCost);
                                costViewModel.setView(costViewN);
                                costViewN.setIViewModel(costViewModel);
                                // Costviewn.init();
                                // Costviewn.start();


                            }
                        }

                        //view.showItems(items);

                    });
                } catch (Exception e) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            view.showMessage2("Error");
                        }
                    });
                }
            }
        });
    }

    /**
     * Add Cost for Specific user
     * if cost add display all costs of specific user
     * @param cost the cost
     */
    @Override
    public void addItem(Cost cost) {
        service.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    String answer = model.postCost(cost);
                    String answer2 = model.getInfoCost(cost.getUserName());
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            view.showMessageCost(answer2);
                            //view.showMessage(answer);
                            //view.showItems(items);
                        }
                    });
                } catch (Exception e) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            // view.showMessage("Error");
                        }
                    });
                }
            }
        });
    }

    /**
     * get costs by username
     * display on the ui all the costs
     * @param userName
     */
    @Override
    public void getMyCosts(String userName) {
        service.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    String answer = model.getInfoCost(userName);
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            view.showMessageCost(answer);
                            //view.showItems(items);
                        }
                    });
                } catch (Exception e) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            // view.showMessage("Error");
                        }
                    });
                }
            }
        });
    }


    /**
     * get costs filter by date from - until
     * display in view for specific user name
     *
     * @param filterDate
     */
    @Override
    public void getSpecialCostsByDate(FilterDateByUserName filterDate) {
        service.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    String answer = model.getCostsByDate(filterDate);
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            view.showMessageCost(answer);
                            //view.showItems(items);
                        }
                    });
                } catch (Exception e) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            // view.showMessage("Error");
                        }
                    });
                }
            }
        });
    }
}
