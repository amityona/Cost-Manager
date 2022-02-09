package view;

import viewModel.ViewModel;

public interface IView {
    /**
     * Init. the UI
     */
    void init();

    /**
     * Start. The UI
     */
    void start();

    /**
     * Show message. in the UI
     *
     * @param message the message
     */
    void showMessage(String message);

    /**
     * Show message 2. in UI-2
     *
     * @param message the message
     */
    void showMessage2(String message);

    /**
     * Sets i view model.
     *
     * @param vm the vm
     */
    void setIViewModel(ViewModel vm);
    /**
     * Init.
     */
    void initCost();

    /**
     * Start the frame
     */
    void startCost();

    /**
     * Display answer from server
     * @param message
     */
    void showMessageCost(String message);


}
