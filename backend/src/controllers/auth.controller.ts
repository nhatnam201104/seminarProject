import { Request, Response } from "express";

export const Login = (req: Request, res: Response) => {
    const data = req.body;
    console.log(data);
    res.send("/")
}