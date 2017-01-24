package com.kdotj.demo.listviewdemo;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Sample Data Model of a Contact
 */

class ContactObject {

    private static final String STUB_DATA = "[{\"first_name\":\"Percy\",\"last_name\": \"Haynes\", \"phone\":\"(257) 302-5960\", \"address\":\"757 3rd Street West Upland, CA 91784\"},\n" +
            "{\"first_name\":\"Lula\" ,\"last_name\": \"Beck\", \"phone\":\"(842) 388-8789\", \"address\":\"288 Broadway Menomonee Falls, WI 53051\"},\n" +
            "{\"first_name\":\"Kevin\", \"last_name\":\"Floyd\", \"phone\":\"(173) 647-0870\", \"address\":\"996 Front Street North Cleveland, TN 37312\"},\n" +
            "{\"first_name\":\"Edmund\", \"last_name\":\"George\", \"phone\":\"(723) 117-3775\", \"address\":\"649 Route 44 Odenton, MD 21113\"},\n" +
            "{\"first_name\":\"Elsie\", \"last_name\":\"Bishop\", \"phone\":\"(486) 811-0330\", \"address\":\"564 Morris Street Grand Forks, ND 58201\"},\n" +
            "{\"first_name\":\"Debra\", \"last_name\":\"May\", \"phone\":\"(625) 487-4619\", \"address\":\"42 Route 10 Lady Lake, FL 32159\"},\n" +
            "{\"first_name\":\"Iris\", \"last_name\":\"Bowers\", \"phone\":\"(450) 654-1412\", \"address\":\"999 Hamilton Road Thibodaux, LA 70301\"},\n" +
            "{\"first_name\":\"Abel\", \"last_name\":\"Clarke\", \"phone\":\"(150) 388-3448\", \"address\":\"456 Canterbury Drive Hampton, VA 23666\"},\n" +
            "{\"first_name\":\"Erika\", \"last_name\":\"Burns\", \"phone\":\"(249) 621-5946\", \"address\":\"887 Adams Street Fort Lauderdale, FL 33308\"},\n" +
            "{\"first_name\":\"Lois\", \"last_name\":\"Willis\", \"phone\":\"(324) 434-0310\", \"address\":\"25 White Street Cumberland, RI 02864\"},\n" +
            "{\"first_name\":\"Catherine \", \"last_name\":\"Adkins\", \"phone\":\"(594) 765-6167\", \"address\":\"442 Maple Avenue Tupelo, MS 38801\"},\n" +
            "{\"first_name\":\"Sonya\", \"last_name\":\"Barnes\", \"phone\":\"(390) 604-9142\", \"address\":\"488 Water Street Cumberland, RI 02864\"},\n" +
            "{\"first_name\":\"Keith\", \"last_name\":\"Ford\", \"phone\":\"(694) 507-2849\", \"address\":\"17 Locust Lane Bedford, OH 44146\"},\n" +
            "{\"first_name\":\"Brian\", \"last_name\":\"Vega\", \"phone\":\"(202) 278-2988\", \"address\":\"979 Hilltop Road Feasterville Trevose, PA 19053\"},\n" +
            "{\"first_name\":\"Roger\", \"last_name\":\"Bates\", \"phone\":\"(194) 923-7635\", \"address\":\"814 Jefferson Street Leesburg, VA 20175\"},\n" +
            "{\"first_name\":\"Alexandra\", \"last_name\":\"Estrada\", \"phone\":\"(433) 629-5795\", \"address\":\"224 Clay Street Yuba City, CA 95993\"},\n" +
            "{\"first_name\":\"Carmen\", \"last_name\":\"Berry\", \"phone\":\"(104) 949-6301\", \"address\":\"338 Route 30 Clarkston, MI 48348\"},\n" +
            "{\"first_name\":\"Kurt\", \"last_name\":\"Christensen\", \"phone\":\"(804) 808-6568\", \"address\":\"588 Amherst Street Waldorf, MD 20601\"},\n" +
            "{\"first_name\":\"Sidney\", \"last_name\":\"Dixon\", \"phone\":\"(156) 302-7143\", \"address\":\"457 Ann Street Arvada, CO 80003\"},\n" +
            "{\"first_name\":\"Rafael\", \"last_name\":\"Doyle\", \"phone\":\"(439) 270-8230\", \"address\":\"83 Water Street Chicopee, MA 01020\"},\n" +
            "{\"first_name\":\"Johnathan\", \"last_name\":\"Stone\", \"phone\":\"(458) 189-8766\", \"address\":\"641 Locust Street Bridgeton, NJ 08302\"},\n" +
            "{\"first_name\":\"Ben\", \"last_name\":\"Lamb\", \"phone\":\"(828) 226-3755\", \"address\":\"180 Hamilton Street Mableton, GA 30126\"},\n" +
            "{\"first_name\":\"Lynette\", \"last_name\":\"Mack\", \"phone\":\"(590) 783-0237\", \"address\":\"323 4th Street South Thibodaux, LA 70301\"},\n" +
            "{\"first_name\":\"Johnnie\", \"last_name\":\"Obrien\", \"phone\":\"(166) 452-3354\", \"address\":\"120 Beechwood Drive Powell, TN 37849\"},\n" +
            "{\"first_name\":\"Terry\", \"last_name\":\"Klein\", \"phone\":\"(122) 401-6446\", \"address\":\"794 Main Street Yuba City, CA 95993\"},\n" +
            "{\"first_name\":\"Rosa\", \"last_name\":\"Nguyen\", \"phone\":\"(435) 172-6133\", \"address\":\"256 Sycamore Drive Yorktown Heights, NY 10598\"},\n" +
            "{\"first_name\":\"Colleen\", \"last_name\":\"Hines\", \"phone\":\"(911) 871-4273\", \"address\":\"425 Sheffield Drive Nampa, ID 83651\"},\n" +
            "{\"first_name\":\"Alyssa\", \"last_name\":\"Mullins\", \"phone\":\"(680) 270-8665\", \"address\":\"674 Division Street Jamestown, NY 14701\"},\n" +
            "{\"first_name\":\"Reginald\", \"last_name\":\"Peterson\", \"phone\":\"(584) 672-6687\", \"address\":\"738 Cardinal Drive Ada, OK 74820\"},\n" +
            "{\"first_name\":\"Lana\", \"last_name\":\"Douglas\", \"phone\":\"(221) 653-2849\", \"address\":\"943 Grove Avenue Harrison Township, MI 48045\"},\n" +
            "{\"first_name\":\"Wilma\", \"last_name\":\"Wilkerson\", \"phone\":\"(381) 562-0809\", \"address\":\"75 Roosevelt Avenue Murfreesboro, TN 37128\"},\n" +
            "{\"first_name\":\"Gladys\", \"last_name\":\"Daniels\", \"phone\":\"(136) 293-7012\", \"address\":\"937 Jefferson Court Paramus, NJ 07652\"},\n" +
            "{\"first_name\":\"Alma\", \"last_name\":\"Foster\", \"phone\":\"(546) 350-4674\", \"address\":\"479 Cleveland Street Brooklyn, NY 11201\"},\n" +
            "{\"first_name\":\"Eva\", \"last_name\":\"Gomez\", \"phone\":\"(768) 722-4553\", \"address\":\"150 Fairway Drive Middletown, CT 06457\"},\n" +
            "{\"first_name\":\"Fernando\", \"last_name\":\"Porter\", \"phone\":\"(297) 653-9394\", \"address\":\"695 Winding Way South Ozone Park, NY 11420\"},\n" +
            "{\"first_name\":\"Bryant\", \"last_name\":\"Hale\", \"phone\":\"(219) 800-0260\", \"address\":\"903 Eagle Street Hampton, VA 23666\"},\n" +
            "{\"first_name\":\"Regina\", \"last_name\":\"Holmes\", \"phone\":\"(771) 425-0051\", \"address\":\"561 Linda Lane Richmond, VA 23223\"},\n" +
            "{\"first_name\":\"Clarence\", \"last_name\":\"Tyler\", \"phone\":\"(840) 592-4614\", \"address\":\"306 Meadow Street Waxhaw, NC 28173\"},\n" +
            "{\"first_name\":\"Leticia\", \"last_name\":\"Jensen\", \"phone\":\"(753) 733-0894\", \"address\":\"52 Columbia Street Utica, NY 13501\"},\n" +
            "{\"first_name\":\"Blanche\", \"last_name\":\"Abbott\", \"phone\":\"(443) 596-9912\", \"address\":\"353 Summit Avenue Lincoln Park, MI 48146\"},\n" +
            "{\"first_name\":\"Byron\", \"last_name\":\"Matthews\", \"phone\":\"(792) 303-6759\", \"address\":\"931 Linden Street Essex, MD 21221\"},\n" +
            "{\"first_name\":\"Hattie\", \"last_name\":\"Hodges\", \"phone\":\"(195) 896-4797\", \"address\":\"9 Cross Street Neenah, WI 54956\"},\n" +
            "{\"first_name\":\"Robert\", \"last_name\":\"Hughes\", \"phone\":\"(691) 934-3554\", \"address\":\"536 Main Street South Mount Airy, MD 21771\"},\n" +
            "{\"first_name\":\"Cody\", \"last_name\":\"Andrews\", \"phone\":\"(226) 253-4911\", \"address\":\"765 Lincoln Avenue Galloway, OH 43119\"},\n" +
            "{\"first_name\":\"Thomas\", \"last_name\":\"Murphy\", \"phone\":\"(426) 946-7140\", \"address\":\"83 Windsor Court Ft Mitchell, KY 41017\"},\n" +
            "{\"first_name\":\"Tomas\", \"last_name\":\"Higgins\", \"phone\":\"(330) 241-3242\", \"address\":\"166 Ann Street Avon, IN 46123\"},\n" +
            "{\"first_name\":\"Miranda\", \"last_name\":\"Long\", \"phone\":\"(520) 305-9781\", \"address\":\"870 Main Street East Defiance, OH 43512\"},\n" +
            "{\"first_name\":\"Ivan\", \"last_name\":\"Stanley\", \"phone\":\"(700) 785-5593\", \"address\":\"61 Jefferson Court Kissimmee, FL 34741\"},\n" +
            "{\"first_name\":\"Robyn\", \"last_name\":\"Hunt\", \"phone\":\"(481) 483-6240\", \"address\":\"76 Court Street Ankeny, IA 50023\"},\n" +
            "{\"first_name\":\"Julia\",\"last_name\":\"Watson\", \"phone\":\"(349) 270-9052\", \"address\":\"42 Dogwood Drive Camden, NJ 08105\"}]";

    @SerializedName("first_name")
    public String firstName;

    @SerializedName("last_name")
    public String lastName;

    @SerializedName("phone")
    public String phone;

    @SerializedName("address")
    public String address;

    public static List<ContactObject> getContactList(){
        Type type = new TypeToken<List<ContactObject>>(){}.getType();
        return new Gson().fromJson(STUB_DATA, type);
    }


}
