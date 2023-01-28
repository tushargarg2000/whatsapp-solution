package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class WhatsappRepository {

    // hashmap to store ( mobileNo , User)
    private HashMap<String , User> userHashMap =  new HashMap<>() ;

    // hashmap to store ( Admin(User) , List<Users> in the group)
    private HashMap<User, List<User>> adminHashMap = new HashMap<>();

    // hashmap to store ( group , List<Users> in the group)
    private  HashMap<Group, List<User>> groupHashMap =new HashMap<>();

    private  HashMap<Group, List<Message>> messageHashMap =new HashMap<>();

    private HashMap<Group,User> groupToAdmin = new HashMap<>() ;


    private int noOfGroup= 1;

    private int noOfMessage =1 ;



    public String createUser(String name, String mobile) throws Exception{

                   if(!userHashMap.containsKey(mobile)){

                       User user =  new User();
                       user.setName(name);
                       user.setMobile(mobile) ;
                       userHashMap.put(mobile,user);

                       return "SUCCESS";

                   }
                   else{
                       throw new Exception("User already exists");
                   }


    }




    public Group createGroup(List<User> users){


        Group group = new Group() ;

        if(users.size() == 2){

              group.setName(users.get(1).getName()) ;
              group.setNumberOfParticipants(2);

        }

        else{

            String groupName = "Group " + noOfGroup ;
            group.setName(groupName);
            group.setNumberOfParticipants(users.size());
            noOfGroup++;


        }


        groupHashMap.put(group,users) ;
        groupToAdmin.put(group,users.get(0));

          return group ;

    }

    public int createMessage(String content){

          int id = noOfMessage ;

          Message message = new Message();
          noOfMessage = noOfMessage + 1;


        return id ;
    }

    public int sendMessage(Message message, User sender, Group group) throws Exception{

          if(groupHashMap.containsKey(group)){

              List<User>  users =  groupHashMap.get(group) ;

              if(users.contains(sender)){

                  List<Message> messages ;

                  if(messageHashMap.containsKey(group)){
                      messages = messageHashMap.get(group);
                  }
                  else{
                      messages = new ArrayList<>();
                  }

                  messages.add(message);

                  messageHashMap.put(group,messages) ;

                  return messages.size() ;
              }

              else{

                  throw new Exception("You are not allowed to send message");
              }


          }

          else{

              throw new Exception("Group does not exist");
          }


        
    }

    public String changeAdmin(User approver, User user, Group group) throws Exception{

        if(groupHashMap.containsKey(group)){

            User currAdmin = groupToAdmin.get(group) ;

            if(currAdmin.equals(approver)) {

                List<User> users = groupHashMap.get(group);

                if (users.contains(user)) groupToAdmin.put(group, user);

                else  { throw new Exception("User is not a participant"); }

            }

            else{

                throw new Exception("Approver does not have rights");

            }

            } // if


        else{

            throw new Exception("Group does not exist");
        }

        return "SUCCESS";
    }

    public int removeUser(User user) throws Exception{


   return 0 ;


    }

    public String findMessage(Date start, Date end, int K) throws Exception{

        return "";

    }
}
