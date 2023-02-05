import {
  Box,
  Card,
  Grid,
  TextField,
  Typography,
  InputAdornment,
  Button,
} from "@mui/material";
import axios from "axios";
import React, { useEffect, useState } from "react";
import SearchIcon from "@mui/icons-material/Search";
import { Link } from "react-router-dom";


function camelCase(str) {
  return str.replace(/(?:^\w|[A-Z]|\b\w)/g, function(word, index)
  {
      return index == 0 ? word.toLowerCase() : word.toUpperCase();
  }).replace(/\s+/g, '');
}

const Feed = () => {
  const [query, setQuery] = useState("");
  const [addJobPost, setPost] = useState();

  //
  useEffect(() => {
    const fetchPosts = async () => {
      const response = await axios.get(`http://localhost:8080/jobPostsSearch/${query}`);
      setPost(response.data);
    };
    const fetchInitialPosts = async () => {
        const response = await axios.get(`http://localhost:8080/allJobPosts`);
        console.log(response);
        setPost(response.data);
    }
    if (query.length === 0) fetchInitialPosts();
    if (query.length > 2) fetchPosts();
  }, [query]);
console.log(addJobPost);

  return (
    <Grid container spacing={2} sx={{ margin: "2%" }}>
      <Grid item xs={12} sx={12} md={12} lg={12}>
      <Box sx={{ display:"flex", flexDirection:"row", justifyContent:"center"}}>
    <Typography 
    variant='h3'sx={{ m: 2 }} align='center'>Recommended Jobs</Typography>
    </Box>
        <Box>
          <TextField
                    style={{ height: 40, width: "75%", borderColor: 'red', borderWidth: 1,  marginBottom: 20 }}
            InputProps={{
              startAdornment: (
                <InputAdornment position="start">
                  <SearchIcon />
                </InputAdornment>
              ),
            }}
            placeholder="Search..."
            sx={{ width: "75%", padding: "2% auto" }}
            fullWidth
            onChange={(e) => setQuery(e.target.value)}
          />
          <Link to="/employer/dashboard" style={{textDecoration: 'none'}}>
          <Button sx={{margin: "1% 3%" }} variant="contained" color="success">
          Create Job Post
      </Button>
      </Link>
        </Box>
      </Grid>
      {addJobPost &&
        addJobPost.map((p) => {
          return (
            <Grid key={p.id} item xs={12} md={6} lg={4}>
              <Card sx={{ padding: "3%", overflow: "hidden", width: "84%" ,border: '1px solid grey'}}>
                <Typography
                  variant="h5"
                  sx={{ fontSize: "2rem", fontWeight: "600" ,fontStyle:"initial"}}
                >
             {p.jobtitle}
                </Typography>
                <Typography sx={{ color: "#585858", marginTop:"2%" }} variant="body" >
                  Description: {p.description}
                </Typography>
                <br />
                <br />
                <Typography>
                  Years of Experience: {p.experiance} years
                </Typography>

                <Typography gutterBottom  variant="body">Skills : </Typography>
                {p.techstack.map((s, i) => {
                  return (
                    <Typography variant="body" gutterBottom key={i}>
                      {s}
                      {`.`}
                    </Typography>
                  );
                }
                )}
  
              </Card>
            </Grid>
          );
        })}
    </Grid>
  );
};

export default Feed;
