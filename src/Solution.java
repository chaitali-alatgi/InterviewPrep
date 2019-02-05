import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Result {

    /*
     * Complete the 'timeOfBuffering' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER arrivalRate
     *  2. INTEGER_ARRAY packets

        /*
         * Complete the 'validateAddresses' function below.
         *
         * The function is expected to return a STRING_ARRAY.
         * The function accepts STRING_ARRAY addresses as parameter.
         */

        public static List<String> validateAddresses(List<String> addresses) {
            // Write your code here
            ArrayList<String> result = new ArrayList<>();

            for(String address : addresses) {
                if(address.contains(".")) {
                    String[] arrSubNet = address.split(".");
                    boolean isValid= false;
                    for (String subNet : arrSubNet) {
                        if(subNet.isEmpty()){
                            isValid = false;
                            break;
                        } else if( Integer.parseInt(subNet) > 255) {
                            isValid = false;
                            break;
                        } else if(subNet.matches("^0+")) {
                            isValid = false;
                            break;
                        } else {
                            isValid = true;
                        }
                    }
                    if(isValid) {
                        result.add("IPv4");
                    } else {
                        result.add("Neither");
                    }
                } else if(address.contains(":")) {
                    String[] arrSubNet = address.split(":");
                    boolean isValid= false;
                    for (String subNet : arrSubNet) {
                        if(subNet.isEmpty()) {
                            isValid = false;
                            break;
                        } else if(subNet.length() > 4) {
                            isValid = false;
                            break;
                        } else if(!subNet.matches("[0-9a-fA-F]{1,4}")) {
                            isValid = false;
                            break;
                        } else {
                            isValid = true;
                        }
                    }
                    if(isValid) {
                        result.add("IPv6");
                    } else {
                        result.add("Neither");
                    }
                }
            }

            return result;
        }

    }

    public class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
         //   BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int addressesCount = Integer.parseInt(bufferedReader.readLine().trim());

            List<String> addresses = IntStream.range(0, addressesCount).mapToObj(i -> {
                try {
                    return bufferedReader.readLine();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            })
                    .collect(Collectors.toList());

            List<String> result = Result.validateAddresses(addresses);

            System.out.println(
                    result.stream()
                            .collect(Collectors.joining("\n"))
                            + "\n"
            );

            bufferedReader.close();
           // bufferedWriter.close();
        }

}
