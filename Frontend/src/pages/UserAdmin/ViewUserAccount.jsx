import UsersRolesTable from "./components/UserProfile/UserRolesTable";
import { Button, Group, Text, TextInput } from "@mantine/core";
import UserAdminHeader from "./components/UserAdminHeader";

import { useEffect, useState } from "react";
import axios from "axios";

import ButtonMenu from "./components/ButtonMenu";

function AdminHome() {
  // State to store data
  const [users, setUsers] = useState([]);

  useEffect(function loadData() {
    // Load data from backend API
    axios
      .get("http://localhost:8080/viewuseraccount/all")
      .then(function (response) {
        // Store data into react state
        console.log(response);
        setUsers(response.data);
      });
    // [] means the loadData function only runs once when the page first loads
  }, []);

  return (
    <div>
      <h1>Admin Home</h1>
      <Group>
        <UserAdminHeader />
      </Group>
      <ButtonMenu />
      <UsersRolesTable data={users} setData={setUsers} />
    </div>
  );
}

export default AdminHome;
