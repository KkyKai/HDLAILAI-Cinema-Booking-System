import UAHomeButton from "./UAHomeButton";
import axios from "axios";
import React, { useState, useEffect } from "react";

import {
  Avatar,
  Badge,
  Table,
  Group,
  Text,
  Select,
  ScrollArea,
  TextInput,
  Button,
  Anchor,
} from "@mantine/core";

export function UsersRolesTable({ data }) {

  /*const [id, setId] = useState("");
  // for button onClick= {handleSuspend (item.id)}

  function handleSuspend(id) {
    axios
      .delete(`http://localhost:8080/suspenduseraccount/${id}`, {
        suspended: true,
      })
      .then(() => {
        setId (() =>
          data.map ( (user) =>
            user.id === id ? { ...user, suspended: true } : user
          )
        );
      })
      
  } */
  


  const rows = data.map((item, index) => (
    <tr key={index}>
      <td>
        <div style={{ textAlign: "left" }}>
          <Text>{item.name}</Text>

        </div>
      </td>

      <td>
        <div style={{ textAlign: "left" }}>
          <Text>{item.email}</Text>
        </div>
      </td>

      <td>
        {/*  <Select data={rolesData} defaultValue={item.role} variant="unstyled" /> */}
        <Text>{item.userProfile.profileName}</Text>
      </td>
      <td>
        {
          (item.suspended = true ? (
            <Button variant="outline" radius="xl" size="xs" uppercase>
              Active
            </Button>
          ) : (
            <Button 
              variant="outline"
              radius="xl"
              size="xs"
              color="gray"
              uppercase
            >
              Suspended
            </Button>
          ))
        }
      </td>

      <td>
        <UAHomeButton />
      </td>
    </tr>
  ));

  return (
    <ScrollArea>
      <Table miw={1200} verticalSpacing="sm">
        <thead>
          <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Role</th>
            <th>Status</th>
            <th>Update</th>
          </tr>
        </thead>
        <tbody>{rows}</tbody>
      </Table>
    </ScrollArea>
  );
}

export default UsersRolesTable;
