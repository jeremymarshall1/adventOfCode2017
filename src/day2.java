public class day2 implements Solution {
    public void solve (String[] args) {

        String input = """
                790\t99\t345\t1080\t32\t143\t1085\t984\t553\t98\t123\t97\t197\t886\t125\t947
                302\t463\t59\t58\t55\t87\t508\t54\t472\t63\t469\t419\t424\t331\t337\t72
                899\t962\t77\t1127\t62\t530\t78\t880\t129\t1014\t93\t148\t239\t288\t357\t424
                2417\t2755\t254\t3886\t5336\t3655\t5798\t3273\t5016\t178\t270\t6511\t223\t5391\t1342\t2377
                68\t3002\t3307\t166\t275\t1989\t1611\t364\t157\t144\t3771\t1267\t3188\t3149\t156\t3454
                1088\t1261\t21\t1063\t1173\t278\t1164\t207\t237\t1230\t1185\t431\t232\t660\t195\t1246
                49\t1100\t136\t1491\t647\t1486\t112\t1278\t53\t1564\t1147\t1068\t809\t1638\t138\t117
                158\t3216\t1972\t2646\t3181\t785\t2937\t365\t611\t1977\t1199\t2972\t201\t2432\t186\t160
                244\t86\t61\t38\t58\t71\t243\t52\t245\t264\t209\t265\t308\t80\t126\t129
                1317\t792\t74\t111\t1721\t252\t1082\t1881\t1349\t94\t891\t1458\t331\t1691\t89\t1724
                3798\t202\t3140\t3468\t1486\t2073\t3872\t3190\t3481\t3760\t2876\t182\t2772\t226\t3753\t188
                2272\t6876\t6759\t218\t272\t4095\t4712\t6244\t4889\t2037\t234\t223\t6858\t3499\t2358\t439
                792\t230\t886\t824\t762\t895\t99\t799\t94\t110\t747\t635\t91\t406\t89\t157
                2074\t237\t1668\t1961\t170\t2292\t2079\t1371\t1909\t221\t2039\t1022\t193\t2195\t1395\t2123
                8447\t203\t1806\t6777\t278\t2850\t1232\t6369\t398\t235\t212\t992\t7520\t7304\t7852\t520
                3928\t107\t3406\t123\t2111\t2749\t223\t125\t134\t146\t3875\t1357\t508\t1534\t4002\t4417""";

        String testInput = """
                5\t1\t9\t5
                7\t5\t3
                2\t4\t6\t8""";

        String testInput2 = """
                5\t9\t2\t8
                9\t4\t7\t3
                3\t8\t6\t5""";


        String[] individualLines = input.split("\n");
        int sumOfDiff = 0;
        for (String line: individualLines)
        {
            String[] individualItems = line.split("\\t");

            for (String item: individualItems){
                for (String item2: individualItems) {
                    int parsedItem = Integer.parseInt(item);
                    int parsedItem2 = Integer.parseInt(item2);
                    if(parsedItem % parsedItem2 == 0) {
                        if(parsedItem != parsedItem2) {
                            sumOfDiff += (parsedItem / parsedItem2);
                            continue;
                        }
                    }
                }
            }

        }
        System.out.println(sumOfDiff);
    }
}