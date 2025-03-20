import express, { Request, Response } from "express";
import router from "./routes/route";

// Create a new express application instance
const app = express();

// Set the network port
const port = process.env.PORT || 3000;

app.use("/api/", router);
// Start the Express server
app.listen(port, () => {
    console.log(`The server is running at http://localhost:${port}`);
});