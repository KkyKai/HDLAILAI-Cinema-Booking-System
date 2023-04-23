import { useEffect, useState } from "react";
import { TextInput, Button} from "@mantine/core";
import axios from "axios";


function CMCreateRoom() {
    const [roomName, setroomName] = useState("");
    

//axios
useEffect(() => {
  axios
  .get("http://localhost:8080/createuserprofile/all")
  .then(({ data }) => {
    if (data) {
      const options = data.map((profile) => {
        return { value: profile.id, label: profile.profileName };
      });
      setProfileOptions(options);
    }
  })
  .catch((error) => console.log(error));
}, []);

  function handleSubmit(event) {
    // Prevent submit from refreshing the page
    event.preventDefault();
    console.log(userProfileId);
    // handle submit here
    axios
    //need change
      .post("http://localhost:8080/login", {
        roomName: roomName,
      })
      .then((response) => {
        alert(response.data);
      })
      .catch((error) => {
        console.log(error);
        alert(error.response.data);
      });
    }

   return (
    <form className="CMCreateRoom" onSubmit={handleSubmit}>
      <div className="formFields">

      <TextInput
          className="roomNameField"
          label="Room Name:"
          value={roomName}
          onChange={(event) => setroomName(event.currentTarget.value)}
        />
        </div>
        <Button className="submitBtn" type="submit">
          Submit
        </Button>
    </form>
   );
}

export default CMCreateRoom;