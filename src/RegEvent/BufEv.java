package RegEvent;

import java.util.ArrayList;
import java.util.List;

public class BufEv {
    //public static String path="F:myEvent.txt";                          //путь к файлу
    public static String path="myEvent.txt";                          //путь к файлу
    public static String header="Программа <MyEvent>.";

    public static ArrayList<String[]> masMyEvent = new ArrayList<String[]>();   //массиив для чтения событий

    public static String[] textMode={"Enter","View","Request","Help","Exit"}; //опции меню
    public static int endMode= textMode.length;                            //количество опций меню

    public static String[] textReq={"1. Time spend on the event",
            "2. Maximum time spent on the event for a period",
            "3. Minimum time spent on the event for a period",
            "4. What events are waiting for us after the entered date",
            "5. Help",
            "6. Exit"};
    public static int endReq= textReq.length;                            //количество опций меню запросов
    public static String currDate;                                      //текущая дата
    public static String nameEv;                                        //текущее название события
    public static String timeEv;                                        //время события
    public static int nDirEnum;                                         //текущий номер в перечислении
    public static String futureDate;                                    //текущаяя дата будущего события
    public static String nameSos;                                       //текущее имя состояния
    static String[] topic0 = new String[]{"APPLICATION PURPOSEЯ",
            "The MyEvent application is designed for entering and viewing user events.",
            "Events are understood as a limited set of actions, such as: study, sports,",
            "recreation, friends, etc. For each event , the following is specified:",
            "  1. the date of its entry,",
            "  2. title,",
            "  3. time spent on the event,",
            "  4. state (was or will be)",
            "  5. date of execution of the event whose state <Will be>"};
    static String[] topic1 = new String[]{"APPLICATION FUNCTIONS",
            "The MyEvent application implements the following functions:",
            "  1. Entering event data",
            "  2. Writing the entered data to a text file (usually on a USB stick)",
            "  3. Viewing the entered data",
            "  4.Execution of queries such as <How many hours spent on the event <Rest>, etc.",
            "  5. Просмотр справки"};
    static String[] topic2 = new String[]{"ENTERING EVENT DATA",
            "The following events are provided in the application: Study, Road, Entertainment, Internet,",
            "Sports, Friends, Food, Etc.",
            "For each event , enter:",
            "  1. current calendar date in the form of dd-mm-yyyy,",
            "  2. event name,",
            "  3. time spent in hours (comma delimiter),",
            "  4. state (was or will be),",
            "  5. the date for the state <Will be> in the form dd-mm-yyyy",
            "All data can be added to a file. At the moment, this is a file myEvent.txt on a flash drive.",
            "Editing of the entered data is not provided yet."};
    static String[] topic3 = new String[]{"VIEWING THE ENTERED DATA",
            "In this mode, data is read from the file myEvent.txt and output to the screen in the form of:",
            "    +---------------------------------------------------------------+",
            "    |  Date            Event         Time      Stat   Date completed|",
            "    +---------------------------------------------------------------+",
            "    | 16-06-2022      |Study        | 5.0 |    was   | 16-06-2022   |"};
    static String[] topic4 = new String[]{"EXECUTING REQUESTS",
            "The application provides the following database queries:",
            " ",
            "1. Time spent on an event during the period",
            "2. Maximum time spent on an event for a period",
            "3. Minimum time spent on an event for a period",
            "4. What events are waiting for us after the entered date",
            " ",
            "IN MODE 1, the time spent on the specified event for the specified period is calculated.",
            "           If the period is not specified, then the calculation goes for all events. The result is displayed on the screen.",
            "In MODE 2, the maximum time for the specified event is determined. If the period is not specified,",
            "           then the calculation goes for all events. The result is displayed on the screen.",
            "In MODE 3, the minimum time for the specified event is determined. If the period is not specified,",
            "           then the calculation goes for all events. The result is displayed on the screen.",
            "In MODE 4, all future events for the specified period are displayed on the screen. If the period is not specified,",
            "           then all events with the state <Will be displayed on the screen>."};
    protected static List<String[]> textHelp = new ArrayList<String[]>();
}
