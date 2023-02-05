import React, { useState } from "react";
import {
  Typography,
  TextField,
  Button,
  Paper,
  Box,
} from "@mui/material";
import { useNavigate } from "react-router-dom";
const initial = { jobtitle: "", experiance: 0, techstack: [], description:"" };

const Create = () => {
    const skillSet = [
        {
          name: "Blockchain"
        },
        {
          name: "Java"
        },
        {
          name: "Android"
        },
        {
          name: "IOS"
        },
        {
          name: "Software Testing"
        }
      ];
  const navigate = useNavigate();
  const [form, setForm] = useState(initial);

  const handleSubmit = (e) => {
    e.preventDefault();
    fetch("http://localhost:8080/addJobPost", {
      method: "POST", // or 'PUT'
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(form),
    })
      .then((response) => console.log(response))
      .then((data) => {
        console.log("Success:", data);
      })
      .catch((error) => {
        console.error("Error:", error);
      });
      navigate('/employee/joblist');
  };

  const { jobtitle, experiance, description } = form;

  const handleChange = (e) => {
    setForm({...form , techstack : [...form.techstack, e.target.value]});
  }

  return (
    <Paper sx={{ padding:"2%"}} elevation={3}>
      <Typography sx={{ margin: "3% auto" }} align="center" variant="h5">
        Create New Post
      </Typography>
      <form autoComplete="off" noValidate onSubmit={handleSubmit}>
        <Box
          sx={{
            display: "flex",
            justifyContent: "center",
            flexDirection: "column",
          }}
        >
          <TextField
            type="string"
            sx={{ width: "50%", margin: "2% auto" }}
            required
            onChange={(e) => setForm({ ...form, jobtitle: e.target.value })}
            label="Job profile"
            variant="outlined"
            value={jobtitle}
          />
          <TextField
            min="0"
            max="20"
            type="number"
            sx={{ width: "50%", margin: "2% auto" }}
            required
            onChange={(e) => setForm({ ...form, experiance: e.target.value })}
            label="Years of Experience"
            variant="outlined"
            value={experiance}
          />
           <TextField
            type="string"
            sx={{ width: "50%", margin: "2% auto" }}
            required
            multiline
            rows={4}
            onChange={(e) => setForm({ ...form, description: e.target.value })}
            label="Job description"
            variant="outlined"
            value={description}
          />
          <Box sx={{ margin:"1% auto"}}>
          <h3>Please mention required skills</h3>
         <ul>
        {skillSet.map(({ name }, index) => {
          return (
            <li key={index}>
              <div >
                <div>
                  <input
                    type="checkbox"
                    id={`custom-checkbox-${index}`}
                    name={name}
                    value={name}
                    onChange={handleChange}  
                  />
                  <label htmlFor={`custom-checkbox-${index}`}>{name}</label>
                </div>
              </div>
            </li>
          );
        })}
       
      </ul>
          </Box>
          <Button
            sx={{ width: "50%", margin: "2% auto" }}
            variant="contained"
            type="submit"
          >
            Submit
          </Button>
        </Box>
      </form>
    </Paper>
  );
};

export default Create;
