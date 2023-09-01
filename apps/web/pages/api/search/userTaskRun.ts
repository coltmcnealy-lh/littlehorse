import { NextApiRequest, NextApiResponse } from "next";

export default async function handler(
    req: NextApiRequest,
    res: NextApiResponse
) {
    if (req.method === "POST") {
        console.log(req.body)
        const raw = await fetch(process.env.API_URL + "/search/userTaskRun", {
            method: "POST",
            body: req.body,
            mode: "cors",
            credentials: "include",
            headers: {
                "Content-Type": "application/json",
                Accept: "*/*",
            },
        });
        if (raw.ok) {
            const content = await raw.json();
            return res.send(content);
        }
        res.send({
            error: "Something goes wrong.",
        });
    }
}
